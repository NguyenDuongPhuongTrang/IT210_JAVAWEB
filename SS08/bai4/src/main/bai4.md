PHẦN 1 – PHÂN TÍCH BÀI TOÁN
1. Input / Output

- Input:

username (String)

password (String)

confirmPassword (String)

- Các tình huống có thể xảy ra:

password hoặc confirmPassword = null

Một trong hai bị rỗng

Hai giá trị khác nhau

Hai giá trị giống nhau

- Output:

Hợp lệ: password và confirmPassword trùng nhau

Không hợp lệ: trả về lỗi validation
2. Bản chất vấn đề

Đây không phải validation đơn giản trên từng field riêng lẻ.

→ Nó là cross-field validation (validate giữa nhiều field trong cùng object).

Vì vậy:

Không thể dùng mấy annotation như @NotBlank, @Size
Phải có logic để so sánh 2 field với nhau
3. Cách xử lý thông thường (if-else)

Ví dụ:

if (password == null || confirmPassword == null || !password.equals(confirmPassword)) {
throw new RuntimeException("Password không khớp");
}

Hạn chế:
- Logic bị nhét vào Controller/Service → code bẩn
- Không tái sử dụng được
- Dễ bị quên validate ở chỗ khác
- Khó scale khi project lớn
4. Cách tối ưu – Custom Validation ở cấp class

Tạo annotation riêng, ví dụ:

@PasswordMatches

public class RegisterDto {

private String username;

private String password;

private String confirmPassword;

}

Điểm mạnh:
- Tách validation khỏi business logic → code sạch
- Dùng lại được cho nhiều chức năng (đăng ký, đổi mật khẩu…)
- Theo đúng chuẩn Bean Validation
- Dễ mở rộng về sau
5. Lưu ý quan trọng (tránh lỗi NPE)

Sai phổ biến:

password.equals(confirmPassword)

→ sẽ crash nếu password = null

Cách an toàn:

Objects.equals(password, confirmPassword)

PHẦN 2 – ĐÁNH GIÁ GIẢI PHÁP

| Tiêu chí         | If-else (Controller) | Custom Validation |
| ---------------- | -------------------- | ----------------- |
| Code lặp         | Nhiều                | Ít                |
| Tái sử dụng      | Không                | Có                |
| Tách biệt logic  | Kém                  | Tốt               |
| Mở rộng          | Khó                  | Dễ                |
| An toàn lỗi null | Thủ công             | Chuẩn             |
| Clean Code       | Không ổn             | Rất ổn            |

KẾT LUẬN

Giải pháp nên dùng: Custom Class-Level Validation

Vì:
- Đúng chuẩn framework
- Code sạch, dễ đọc
- Tái sử dụng tốt
- Hạn chế bug (đặc biệt null)
- Phù hợp với hệ thống lớn