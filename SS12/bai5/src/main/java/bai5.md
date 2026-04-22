## 1. Scenario Analysis (Các kịch bản lỗi)

### Lỗi 1: Ảnh không hiển thị
- Nguyên nhân: Đặt sai thư mục (không nằm trong `static/images`)
- Hậu quả: Giao diện không load được avatar

**Cách đúng:**

src/main/resources/static/images


---

### Lỗi 2: Xung đột Port
- Nguyên nhân: Không cấu hình hoặc trùng port (8080 đang bị dùng)
- Hậu quả: Ứng dụng không chạy được

**Cách đúng:**

server.port=8081


---

### Lỗi 3: Sai Context Path
- Nguyên nhân: Không cấu hình hoặc gọi sai URL
- Hậu quả: Không truy cập được API hoặc Web

**Cách đúng:**

server.servlet.context-path=/med-manager


---

### Lỗi 4: Thiếu dependency Web
- Nguyên nhân: Quên `spring-boot-starter-web`
- Hậu quả: Không chạy được controller / web

**Cách đúng:**

implementation 'org.springframework.boot:spring-boot-starter-web'