Phần 1 – Phân tích

Việc đưa cấu hình vào application.properties thay vì hard-code trong Java giúp:

Dễ thay đổi: Chỉ sửa 1 nơi, không phải sửa nhiều file
Tách biệt cấu hình và code → code sạch hơn
Linh hoạt môi trường (dev, test, prod dùng cấu hình khác nhau)
Không cần build lại code khi thay đổi thông số

-> Giúp bảo trì và mở rộng hệ thống dễ dàng hơn