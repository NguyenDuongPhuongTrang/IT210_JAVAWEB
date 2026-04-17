Báo Cáo Phân Tích & Thiết Kế Giải Pháp
Custom Validator cho chức năng Rút Tiền (FinTech)

Phần 1: Phân tích Input / Output
1.1. Dữ liệu đầu vào (Input)

Hệ thống nhận các thông tin sau từ người dùng:

withdrawAmount (Long): Số tiền người dùng yêu cầu rút

bankAccountNumber (String): Số tài khoản ngân hàng liên kết

bankName (String): Tên ngân hàng

1.2. Kết quả đầu ra (Output)

- Trường hợp hợp lệ:

Thực hiện giao dịch thành công

Trả về thông báo xác nhận cùng số tiền đã rút

- Trường hợp không hợp lệ:

Hệ thống trả về danh sách lỗi cụ thể, ví dụ:

Nếu số tiền nhỏ hơn 50.000 →
➝ "Số tiền rút phải từ 50.000 VNĐ trở lên"

Nếu không chia hết cho 10.000 →
➝ "Số tiền phải là bội số của 10.000 VNĐ (ví dụ: 50.000, 60.000...)"

Nếu không nhập số tiền →
➝ "Vui lòng nhập số tiền rút"

Phần 2: Quy tắc nghiệp vụ & ràng buộc

2.1. Điều kiện cần thỏa mãn

Số tiền rút phải đáp ứng đồng thời tất cả các điều kiện sau:

| # | Điều kiện         | Mô tả               | Ví dụ đúng      | Ví dụ sai       |
| - | ----------------- | ------------------- | --------------- | --------------- |
| 1 | Giá trị tối thiểu | ≥ 50.000            | 50.000, 100.000 | 40.000, -10.000 |
| 2 | Bội số            | Chia hết cho 10.000 | 60.000, 150.000 | 55.000, 65.000  |
| 3 | Không rỗng        | Khác null           | 70.000          | null            |


2.2. Các tình huống dữ liệu xấu

withdrawAmount = null
➝ Có thể gây lỗi nếu không kiểm tra trước

withdrawAmount < 0
➝ Không hợp lệ nhưng dễ bị bỏ sót nếu chỉ check bội số

withdrawAmount = 55.000
➝ Đủ lớn nhưng không đúng quy tắc ATM

Phần 3: Định hướng giải pháp

3.1. Sử dụng Custom Annotation

Thay vì xử lý trực tiếp trong Controller, ta xây dựng annotation riêng:

@MultipleOfTenThousand

Mục đích:
- Tách riêng logic kiểm tra khỏi Controller
- Dễ tái sử dụng ở nhiều nơi
- Tuân thủ chuẩn Bean Validation
- Code rõ ràng, dễ bảo trì


Phần 4: Mô tả thuật toán kiểm tra (Pseudocode)

Function isValid(value, context):

    // Bước 1: kiểm tra null
    IF value == null THEN
        RETURN true   // để @NotNull xử lý
    END IF

    // Bước 2: kiểm tra giá trị tối thiểu
    IF value < 50000 THEN
        Ghi lỗi: "Số tiền phải >= 50.000"
        RETURN false
    END IF

    // Bước 3: kiểm tra bội số
    IF value MOD 10000 != 0 THEN
        Ghi lỗi: "Số tiền phải là bội số của 10.000"
        RETURN false
    END IF

    // Bước 4: hợp lệ
    RETURN true

Luồng xử lý minh họa

Input:
withdrawAmount = 55.000

Các bước kiểm tra:

Không phải null → OK

≥ 50.000 → OK

55.000 % 10.000 ≠ 0 → Không hợp lệ

Thông báo: "Số tiền phải là bội số của 10.000 VNĐ"