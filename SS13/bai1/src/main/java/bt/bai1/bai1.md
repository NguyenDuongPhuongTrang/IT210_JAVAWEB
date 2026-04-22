# Phần 1 - Phân tích

## 1. Vì sao thiếu `hibernate.dialect` gây lỗi?

`hibernate.dialect` dùng để xác định loại hệ quản trị cơ sở dữ liệu (MySQL, PostgreSQL,...).

Hibernate cần thông tin này để:
- Sinh câu lệnh SQL phù hợp
- Xử lý kiểu dữ liệu đặc thù
- Tương thích với từng DB

Nếu thiếu:
- Hibernate không biết dùng cú pháp SQL nào
- Không thể khởi tạo SessionFactory
  → Gây lỗi: "Hibernate Dialect must be explicitly set"

---

## 2. Thuộc tính tự động tạo bảng

Thuộc tính:

hibernate.hbm2ddl.auto


Các giá trị:
- `create`: Tạo mới bảng
- `update`: Cập nhật bảng theo Entity (dùng phổ biến)
- `create-drop`: Tạo khi start, xóa khi stop
- `validate`: Chỉ kiểm tra

Để tự động tạo bảng:

hibernate.hbm2ddl.auto=update