PHÂN TÍCH HỆ THỐNG QUẢN LÝ TOUR DU LỊCH
1. Thiết kế Validation & Logic xử lý

a. Mã tour (tourCode)

Yêu cầu:

- Phải bắt đầu bằng VN_ hoặc INT_
- Theo sau là đúng 5 chữ số

Hướng xử lý:

- Có thể dùng @Pattern
- Nhưng để đúng “chất hệ thống” → tạo custom annotation @ValidTourCode

Giúp:

- Tái sử dụng
- 
- Dễ thay đổi rule sau này
- 
b. Giá tour (adultPrice, childPrice)

Yêu cầu:

- Giá người lớn > 0
- Giá trẻ em > 0
- Giá trẻ em ≤ giá người lớn

Hướng xử lý:

- Dùng annotation có sẵn: @Positive cho từng field
- Dùng thêm custom annotation cấp class: @ValidTourPrices

→ Vì cần so sánh giữa 2 field → bắt buộc class-level validation

c. Thời gian tour (startDate, endDate)

Yêu cầu:

startDate ≥ hôm nay
endDate > startDate

Hướng xử lý:

- @FutureOrPresent cho startDate

- Custom annotation @ValidTourDates cho toàn bộ object

→ Đảm bảo logic thời gian luôn đúng và không bị nhập sai thứ tự

2. Luồng xử lý dữ liệu (Flow)

- Bước 1: Người dùng gửi form

User nhập dữ liệu → nhấn submit → gửi request POST lên server

- Bước 2: Controller nhận dữ liệu

@PostMapping

public String create(@ModelAttribute("tour") @Valid TourDto tourDto,
BindingResult bindingResult)

@ModelAttribute: bind dữ liệu form → DTO

@Valid: kích hoạt toàn bộ validation

- Bước 3: Validation hoạt động

Các annotation (chuẩn + custom) chạy tự động

Nếu sai → lỗi được lưu vào BindingResult
- Bước 4: Xử lý kết quả

Nếu có lỗi:

if (bindingResult.hasErrors()) {
return "create-tour";
}

→ quay lại form (không redirect)

Nếu hợp lệ:
→ xử lý lưu DB

- Bước 5: Hiển thị lỗi trên UI

Thymeleaf dùng:
th:field → giữ dữ liệu cũ

th:errors → hiển thị lỗi

→ Trải nghiệm người dùng tốt hơn (không bị mất input)

3. Các kịch bản test rủi ro
- Test Case 1: Giá trị số bất thường

Input:

adultPrice = 999999999999999999

childPrice = -1

Cách hệ thống xử lý:

Dùng Long hoặc BigDecimal để tránh tràn số

@Positive chặn số âm

Spring tự bắt lỗi sai kiểu (type mismatch)

→ Không crash server, chỉ trả lỗi về UI

- Test Case 2: Gửi dữ liệu thiếu / null

Input:

Không gửi tourCode, startDate, endDate

Cách xử lý:

@NotNull, @NotBlank chặn ngay từ đầu

Custom validator có check null → tránh lỗi NPE

→ Hệ thống vẫn chạy ổn định, không văng lỗi 500

- Test Case 3: Ngày không hợp lệ

Input:

startDate = 2024-02-30

Cách xử lý:

Spring không parse được → sinh typeMismatch

Lỗi được đưa vào BindingResult

→ Hiển thị lỗi cho user thay vì crash server


KẾT LUẬN

Thiết kế này có các điểm mạnh:
- Kết hợp tốt giữa annotation chuẩn + custom validation
- Xử lý đúng bản chất cross-field validation
- Luồng xử lý rõ ràng, dễ kiểm soát lỗi
- Hệ thống không bị crash khi gặp input xấu
- Dễ mở rộng khi thêm rule mới