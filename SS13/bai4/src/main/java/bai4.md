# Phần 1 - Phân tích

## 1. So sánh HQL và Native Query

### HQL (Hibernate Query Language)
- Truy vấn dựa trên **Entity (class Java)** thay vì bảng
- Dùng **tên thuộc tính** (field) thay vì tên cột
- Độc lập với hệ quản trị CSDL (MySQL, PostgreSQL,...)
- Tự động mapping kết quả → Object

Ví dụ:

FROM Medicine m WHERE m.expiryDate < :currentDate


---

### Native Query (SQL thuần)
- Truy vấn trực tiếp trên **bảng và cột trong DB**
- Phụ thuộc chặt vào cấu trúc database
- Nếu đổi tên bảng/cột → phải sửa code Java

Ví dụ:

SELECT * FROM medicines WHERE expiry_date < NOW()


---

## 2. Vì sao HQL an toàn hơn khi DB thay đổi?

HQL làm việc thông qua Entity:
- Code Java chỉ phụ thuộc vào **class và field**
- Không phụ thuộc trực tiếp vào tên bảng/cột trong DB

Khi thay đổi database:
- Chỉ cần sửa annotation (@Table, @Column)
- Không cần sửa lại toàn bộ query

Ngược lại với SQL thuần:
- Đổi tên cột → tất cả câu query bị lỗi
- Dễ gây ảnh hưởng diện rộng