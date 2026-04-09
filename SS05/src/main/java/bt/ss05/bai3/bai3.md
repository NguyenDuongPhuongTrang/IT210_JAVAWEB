Luồng dữ liệu (Data Flow)
1. Từ danh sách → chỉnh sửa
- Người dùng bấm "Chỉnh sửa" → chuyển đến /bai3/edit/{id}
2. Controller xử lý
- Lấy id từ URL
- Gọi Service để tìm món ăn tương ứng
3. Service
- Tìm Dish theo id
Trả về dữ liệu (hoặc null nếu không có)
4. Kết quả xử lý
- Nếu tìm thấy:
  + Đưa dish vào Model
  + Trả về trang edit-dish.html
- Nếu không tìm thấy:
  + Redirect về /bai2/dishes
  + Kèm thông báo: "Không tìm thấy món ăn yêu cầu!"
5. Form chỉnh sửa
- Sử dụng th:object="${dish}"
- Dùng th:field để bind dữ liệu vào các input

Luồng tổng quan: 
User click "Edit"
→ GET /bai3/edit/{id}
→ Controller (lấy id)
→ Service (tìm Dish)
→ trả về Dish / null
→ Controller xử lý:
- Có Dish → Model + edit-dish.html
- Null → redirect /bai2/dishes + message
  → Thymeleaf render form (th:object, th:field)