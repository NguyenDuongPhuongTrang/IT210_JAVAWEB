# Thiết kế kiến trúc và phân tích rủi ro thanh toán đa bên

## Phần 1: Thiết kế kiến trúc

### 1. Các Module (Entity)

* **Wallet**: lưu số dư người dùng
* **Vendor**: nhà cung cấp
* **Product**: thuộc Vendor, có stock
* **Order**: đơn hàng tổng
* **OrderDetail**: chi tiết từng sản phẩm theo Vendor

Quan hệ:

* Order 1 - n OrderDetail
* Product 1 - 1 Vendor
* OrderDetail n - 1 Product

---

### 2. Luồng dữ liệu (Data Flow)

1. User thao tác qua Menu (Console)
2. Gửi request xuống Service layer
3. Service xử lý nghiệp vụ và quản lý Transaction
4. DAO layer thao tác với DB

Luồng thanh toán:

1. Begin Transaction (REQUIRED)
2. Kiểm tra số dư ví
3. Với mỗi Vendor:

    * Gọi xử lý riêng (REQUIRES_NEW)
    * Kiểm tra stock
    * Trừ stock
4. Nếu tất cả thành công:

    * Trừ tiền ví
    * Commit
5. Nếu có lỗi:

    * Rollback toàn bộ

---

## Phần 2: Phân tích rủi ro

### 1. Mất kết nối Database khi đang thanh toán

* Gây rollback không hoàn chỉnh nếu không quản lý transaction đúng

### 2. Một Vendor hết hàng giữa quá trình xử lý

* Một phần đơn hàng fail → cần rollback toàn bộ để đảm bảo nguyên tử

### 3. Sản phẩm bị xóa trong lúc thanh toán

* Không tìm thấy product → lỗi logic, cần validate lại trước khi xử lý

### 4. Người dùng nhập dữ liệu sai

* Nhập chữ thay vì số, hoặc số âm → gây crash nếu không validate

### 5. Race condition khi nhiều user mua cùng sản phẩm

* Có thể gây sai lệch stock nếu không có locking

---

## Kết luận

Cần:

* Quản lý transaction theo propagation hợp lý
* Validate dữ liệu đầu vào
* Áp dụng locking hoặc kiểm soát concurrency
* Thiết kế tách lớp rõ ràng để dễ bảo trì và mở rộng
