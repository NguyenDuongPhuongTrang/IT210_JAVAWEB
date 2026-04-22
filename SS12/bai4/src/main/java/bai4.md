## 4.1 Phần 1 - Phân tích

### Spring Boot quản lý Default Properties như thế nào?

Spring Boot sử dụng cơ chế **Auto Configuration** để tự động cấu hình ứng dụng dựa trên các dependency có trong project.

Các giá trị mặc định (default properties) được định nghĩa trong các class có sử dụng annotation `@ConfigurationProperties` bên trong framework.

Khi ứng dụng chạy:
- Nếu không cấu hình gì → dùng giá trị mặc định
- Nếu có cấu hình trong `application.properties` → ghi đè (override) lên default

---

### Tìm danh sách các cấu hình này ở đâu?

Có 3 cách chính:

1. **Tài liệu chính thức của :contentReference[oaicite:0]{index=0}**
    - https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html

2. **Trong IDE (IntelliJ, VSCode)**
    - Gõ prefix (vd: `server.`) sẽ được gợi ý kèm mô tả và giá trị mặc định

3. **Trong source code Spring Boot**
    - Package: `org.springframework.boot.autoconfigure`
    - Các class dạng `*Properties` (ví dụ: `ServerProperties`, `JpaProperties`)  