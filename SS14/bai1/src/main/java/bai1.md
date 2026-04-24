# Phần 1: Phân tích logic

## Vấn đề

Code không sử dụng transaction nên mỗi lệnh update được commit độc lập.

## Diễn biến

* Update `Order` → `"PAID"` (đã commit)
* Xảy ra lỗi 
* `Wallet` chưa trừ tiền

## Nguyên nhân

* Thiếu:

    * `beginTransaction()`
    * `commit()`
    * `rollback()`
* JDBC mặc định **auto-commit = true**

## Hậu quả

* Dữ liệu không nhất quán:

    * Order: đã thanh toán
    * Wallet: chưa bị trừ tiền

## Kết luận

-> Vi phạm **Atomicity** – cần dùng transaction để đảm bảo "all or nothing"
