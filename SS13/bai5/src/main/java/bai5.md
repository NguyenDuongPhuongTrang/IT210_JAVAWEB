# Phần 1s - Kịch bản lỗi hệ thống

## 1. Lỗi LazyInitializationException

### Mô tả
Xảy ra khi truy cập vào danh sách chi tiết thuốc (PrescriptionDetail) sau khi Session đã đóng.

### Nguyên nhân
- Quan hệ OneToMany sử dụng FetchType.LAZY
- Hibernate chưa load dữ liệu ngay
- Sau khi Session đóng, không thể truy vấn thêm dữ liệu

### Ví dụ lỗi

org.hibernate.LazyInitializationException: failed to lazily initialize a collection


### Cách khắc phục
- Dùng FetchType.EAGER (không khuyến khích)
- Hoặc:
    - Fetch join trong HQL
    - Hoặc mở Session trong View (Open Session in View)
    - Hoặc gọi dữ liệu trong Service trước khi trả về

---

## 2. Lỗi số lượng thuốc âm

### Mô tả
Người dùng nhập số lượng thuốc < 0

### Nguyên nhân
- Không validate dữ liệu đầu vào

### Hậu quả
- Dữ liệu sai logic nghiệp vụ
- Có thể ảnh hưởng báo cáo, tồn kho

### Cách khắc phục
- Validate ở Controller:

if(quantity < 0) throw new Exception("Quantity must be positive");

- Hoặc dùng annotation:

@Min(0)


---

## 3. Lỗi trùng port 8081

### Mô tả
Ứng dụng không khởi động được

### Nguyên nhân
- Port 8081 đã bị ứng dụng khác sử dụng

### Thông báo lỗi

Port 8081 was already in use


### Cách khắc phục
- Đổi port trong application.properties:

server.port=8082

- Hoặc tắt ứng dụng đang chiếm port

---

## 4. Lỗi không lưu được đơn thuốc

### Mô tả
Lưu Prescription nhưng không có PrescriptionDetail

### Nguyên nhân
- Thiếu CascadeType.ALL
- Không set quan hệ 2 chiều

### Cách khắc phục
- Thêm:

cascade = CascadeType.ALL

- Set:

detail.setPrescription(prescription);


---

## 5. Lỗi NullPointerException khi render Thymeleaf

### Mô tả
Trang web không hiển thị dữ liệu

### Nguyên nhân
- medicines hoặc prescriptions = null
- Không add attribute vào Model

### Cách khắc phục
- Kiểm tra Controller:

model.addAttribute("medicines", list);