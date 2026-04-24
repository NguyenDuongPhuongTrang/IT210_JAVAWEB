# Phần 1: Phân tích

## Vấn đề

Không sử dụng transaction nên các lệnh update chạy độc lập (auto-commit).

## Diễn biến

* Update `Order` → "CANCELLED" (đã commit)
* Lỗi xảy ra ở bước hoàn kho (ví dụ `productId = null`)
* `Product` không được cập nhật lại stock

## Nguyên nhân

* Thiếu:

    * `beginTransaction()`
    * `commit()`
    * `rollback()`
* JDBC mặc định auto-commit = true

## Hậu quả

* Dữ liệu không nhất quán:

    * Đơn hàng: đã hủy
    * Kho: không được hoàn lại số lượng

Gây thất thoát tồn kho (stock bị thiếu so với thực tế)

## Kết luận

Cần sử dụng transaction để đảm bảo tính nguyên tử (all or nothing)
