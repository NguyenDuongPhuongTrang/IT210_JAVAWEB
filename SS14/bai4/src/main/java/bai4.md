# Phân tích và thiết kế giải pháp giữ hàng (Reserve Stock)

## Phần 1: Phân tích và đề xuất

### 1. I/O

**Input**

* productId
* quantity
* userId
* thời điểm checkout

**Output**

* Giữ hàng thành công (trong 15 phút)
* Thanh toán thành công → trừ kho vĩnh viễn
* Hết thời gian hoặc hủy → hoàn kho

---

### 2. Giải pháp 1: Transaction + trạng thái Pending

Ý tưởng:

* Khi checkout:

    * Tạo Order với trạng thái `PENDING`
    * Trừ stock ngay
    * Lưu thời gian hết hạn (expireTime = now + 15 phút)

* Khi thanh toán:

    * Nếu chưa hết hạn → chuyển `PAID`
    * Nếu hết hạn → từ chối

* Không giữ transaction lâu, chỉ dùng transaction ngắn cho từng bước

---

### 3. Giải pháp 2: Scheduled Task hoàn kho

Ý tưởng:

* Khi checkout:

    * Tạo Order `PENDING`
    * Trừ stock
    * Lưu expireTime

* Scheduler (cron job) chạy định kỳ:

    * Tìm các order `PENDING` đã hết hạn
    * Hoàn lại stock
    * Cập nhật trạng thái `CANCELLED`

* Xử lý an toàn khi:

    * Product bị xóa → bỏ qua hoặc log lỗi
    * Session user hết hạn → không ảnh hưởng vì xử lý server-side

---

## Phần 2: So sánh

| Tiêu chí        | Giải pháp 1 (Pending) | Giải pháp 2 (Scheduler) |
| --------------- | --------------------- | ----------------------- |
| Tốc độ xử lý    | Nhanh                 | Phụ thuộc cron job      |
| An toàn dữ liệu | Tốt                   | Rất tốt                 |
| Tài nguyên      | Thấp                  | Trung bình              |
| Bảo trì code    | Đơn giản              | Phức tạp hơn            |
| Xử lý timeout   | Khó                   | Chủ động, rõ ràng       |

---

## Phần 3: Lựa chọn

Chọn Giải pháp 2 (Scheduler)

Lý do:

* Phù hợp hệ thống lớn, nhiều user
* Không cần giữ transaction lâu
* Chủ động xử lý timeout và hoàn kho
* Dễ mở rộng và scale

---

## Phần 4: Thiết kế luồng xử lý

1. User checkout

2. Begin transaction

3. Kiểm tra stock

    * Nếu không đủ → trả lỗi

4. Trừ stock

5. Tạo Order (PENDING + expireTime)

6. Commit

7. Scheduler chạy định kỳ:

    * Lấy danh sách order hết hạn
    * Với mỗi order:

        * Begin transaction
        * Hoàn stock
        * Update trạng thái CANCELLED
        * Commit

8. Khi user thanh toán:

    * Kiểm tra expireTime
    * Nếu còn hạn → update PAID
    * Nếu hết hạn → từ chối
