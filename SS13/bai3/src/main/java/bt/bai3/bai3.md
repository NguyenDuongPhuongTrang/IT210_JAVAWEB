# Phần 1 - Phân tích

## 1. Vì sao thiếu CascadeType.ALL gây lỗi?

Lỗi:
"TransientObjectException: object references an unsaved transient instance"

Nguyên nhân:
- Prescription có chứa danh sách PrescriptionDetail
- Nhưng các PrescriptionDetail chưa được lưu (transient)
- Khi gọi session.save(prescription), Hibernate chỉ lưu Prescription
- Không tự động lưu các object con

→ Hibernate phát hiện:
Prescription đang tham chiếu tới object chưa tồn tại trong DB → báo lỗi

Giải pháp:
- Dùng CascadeType.ALL để Hibernate tự động:
    - save
    - update
    - delete
      các entity con

---

## 2. Vì sao nên dùng FetchType.LAZY?

FetchType.LAZY:
- Không load danh sách PrescriptionDetail ngay lập tức
- Chỉ load khi thực sự cần

Ưu điểm:
- Tăng hiệu năng
- Tránh load dữ liệu không cần thiết
- Giảm memory

Nếu dùng EAGER:
- Luôn load toàn bộ chi tiết
- Dễ gây chậm hệ thống khi dữ liệu lớn