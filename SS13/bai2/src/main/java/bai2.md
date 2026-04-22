# Phần 1 - Phân tích

## 1. Vì sao Hibernate bắt buộc phải có @Id?

Mỗi Entity trong Hibernate phải có một khóa chính (@Id) vì:

- Dùng để định danh duy nhất mỗi bản ghi trong bảng
- Hibernate cần @Id để:
    - Quản lý trạng thái object (transient, persistent, detached)
    - Thực hiện update/delete chính xác
    - Mapping object ↔ row trong database

Nếu không có @Id:
→ Hibernate không biết đâu là bản ghi duy nhất
→ Báo lỗi: "No identifier specified for entity"

---

## 2. Cách đổi tên bảng trong DB

Mặc định:
- Hibernate sẽ lấy tên class → tên bảng
  → Medicine → Medicine (viết hoa)

Để đổi:
→ Dùng annotation:


@Table(name = "medicines")


Giải thích:
- name: tên bảng trong database
- Có thể đặt khác hoàn toàn với tên class
