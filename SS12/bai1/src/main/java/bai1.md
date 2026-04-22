# Phần 1 – Phân tích

## Vì sao `spring-boot-starter-web` là "Starter"?

"Starter" là một gói dependency tổng hợp giúp tự động thêm các thư viện cần thiết chỉ với một dòng cấu hình.

-> Giúp giảm cấu hình thủ công và tránh thiếu thư viện.

---

## Các thư viện được tự động thêm

Khi dùng `spring-boot-starter-web`, không cần khai báo riêng:

- Web: `spring-web`, `spring-webmvc`
- Server: `tomcat-embed-*` (Embedded Tomcat)
- JSON: `jackson-*`
- Validation: `hibernate-validator`
- Logging: `logback`, `slf4j`

