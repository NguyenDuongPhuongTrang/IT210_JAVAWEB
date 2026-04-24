# Phần 1:  Phân tích 

## 1. Phân tích bài toán (Input/Output)

### Input

* productId
* quantity (số lượng khách mua, thường = 1)
* request đồng thời từ nhiều user

### Output

* Nếu đủ hàng: tạo Order thành công, trừ stock
* Nếu hết hàng: trả về thông báo "Hết hàng"
* Không được xảy ra bán lố (stock < 0 hoặc số đơn vượt tồn kho)

---

## 2. Vấn đề hiện tại

* Nhiều thread cùng đọc stock = 1
* Cả hai đều pass điều kiện kiểm tra
* Cùng trừ stock → dẫn đến stock âm hoặc bán vượt số lượng

Nguyên nhân:

* Thiếu cơ chế kiểm soát concurrency
* Transaction isolation thấp (READ COMMITTED)
* Không có locking

---

## 3. Đề xuất giải pháp

### Cách 1: Optimistic Locking

* Sử dụng `@Version` trong entity Product
* Khi update sẽ kiểm tra version
* Nếu có thay đổi từ transaction khác → throw exception

Ưu điểm:

* Hiệu năng cao
* Phù hợp hệ thống nhiều đọc, ít ghi

Nhược điểm:

* Có thể phải retry nhiều lần khi tranh chấp cao

---

### Cách 2: Pessimistic Locking

* Sử dụng `LockModeType.PESSIMISTIC_WRITE`
* Khóa dòng dữ liệu ngay khi đọc

Ưu điểm:

* Ngăn chặn tuyệt đối over-selling

Nhược điểm:

* Giảm hiệu năng
* Có thể gây deadlock nếu không kiểm soát tốt

---

### Cách 3: Kiểm tra và update trong 1 câu SQL (khuyến nghị)

* Update trực tiếp:

```sql
UPDATE product 
SET stock = stock - 1 
WHERE id = ? AND stock > 0;
```

* Nếu affected rows = 0 → hết hàng

Ưu điểm:

* Tránh race condition
* Hiệu năng cao
* Đơn giản

---

## 4. Thiết kế luồng xử lý

1. Bắt đầu transaction
2. Lấy thông tin Product (có lock nếu cần)
3. Kiểm tra stock:

    * Nếu stock <= 0 → trả "Hết hàng"
4. Trừ stock
5. Tạo Order
6. Commit transaction
7. Nếu lỗi → rollback

---

## 5. Kết luận

Để tránh over-selling cần:

* Đảm bảo xử lý trong 1 transaction
* Áp dụng locking hoặc update có điều kiện
* Không tách riêng bước "check" và "update" khi có concurrency cao
