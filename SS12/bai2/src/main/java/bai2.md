Phần 1 – Phân tích

Trong Spring Boot, ta thường không cần ghi version cho các thư viện thuộc hệ sinh thái Spring vì:

Spring Boot sử dụng Dependency Management (thông qua spring-boot-dependencies)
Nó tự quản lý phiên bản tương thích giữa các thư viện
Tránh xung đột version và lỗi runtime

-> Nghĩa là: chỉ cần khai báo dependency, Spring Boot sẽ tự chọn version phù hợp