##  Bài toán

Form nhiều bước (3 bước) dẫn đến:
- Không submit dữ liệu trong một lần
- Cần giữ dữ liệu xuyên suốt từ bước 1 → bước 3
- Chỉ lưu vào DB ở bước cuối
- Rủi ro: user thoát giữa chừng → dễ phát sinh dữ liệu rác (nếu lưu tạm phía server)

---

##  Cách 1: Hidden Input (phía client)

### Cơ chế

- Dữ liệu từ bước trước được gắn vào các field ẩn (`<input type="hidden">`)
- Mỗi lần submit → gửi lại toàn bộ dữ liệu đã có

### Điểm mạnh

- Không sử dụng tài nguyên RAM của server
- Stateless → dễ mở rộng hệ thống
- Không lo user bỏ dở gây tồn đọng dữ liệu server

### Điểm yếu

- Dữ liệu nằm phía client → có thể bị chỉnh sửa (DevTools)
- Bắt buộc phải kiểm tra (validate) lại toàn bộ ở bước cuối

---

##  Cách 2: `@SessionAttributes` (phía server)

### Cơ chế

- Lưu object form vào session
- Dữ liệu được giữ tự động giữa các request

### Điểm mạnh

- Dữ liệu không lộ ra client → an toàn hơn
- Không bị user chỉnh sửa trực tiếp

### Điểm yếu

- Tốn RAM server (mỗi user = 1 session)
- User thoát giữa chừng → dữ liệu vẫn còn trong session
- Lượng user lớn → nguy cơ ảnh hưởng hiệu năng

---

##  So sánh nhanh

| Tiêu chí | Hidden Input | Session |
|----------|-------------|---------|
| Bảo mật | Có thể bị sửa | An toàn hơn |
| Tài nguyên server | Không tốn RAM | Tốn RAM |
| Khả năng scale | Tốt | Kém hơn |
| Độ phức tạp | Trung bình | Đơn giản hơn |

---

##  Hướng dùng hợp lý

**Ưu tiên:** Hidden Input + validate phía server

**Vì:**
- Nhẹ cho hệ thống → không lo quá tải RAM
- Dù client có thể sửa dữ liệu, vẫn kiểm soát được bằng validate

**Hạn chế dùng Session khi:**
- Hệ thống có nhiều user
- Không kiểm soát tốt vòng đời session

---

##  Best Practice

- Truyền dữ liệu giữa các bước bằng Hidden Input
- Validate toàn bộ dữ liệu ở bước cuối trước khi lưu DB
- Có thể bổ sung kiểm tra (checksum / logic) để phát hiện dữ liệu bị chỉnh sửa