Phân tích logic

Cái if (guestName == null) thực ra không bao giờ chạy ở lần truy cập đầu tiên.

Nguyên nhân:

Annotation @CookieValue("guest_name") mặc định là required = true

Khi user vào lần đầu → chưa có cookie guest_name

Spring không gán null đâu, mà ném luôn lỗi (MissingCookieValueException)

Request bị dừng ngay (HTTP 400), nên method homePage chưa kịp chạy

Hệ quả:

Biến guestName không bao giờ nhận null

Điều kiện if (guestName == null) → không có cơ hội thực thi
→ coi như dead code

Kết luận:

Muốn xử lý user lần đầu thì phải cho phép cookie có thể không tồn tại (tức là không required).