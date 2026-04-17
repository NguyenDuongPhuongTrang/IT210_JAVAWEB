package ss08.bai1.model.dto;

import jakarta.validation.constraints.NotBlank;

public class AddressDTO {
    // Nếu để null sẽ chỉ kiểm tra có nhập giá trị hay không
    // nếu nhập khoảng trắng vẫn sẽ nhận. Giải pháp : notBlank
    @NotBlank(message = "Tên người nhận không được để trống")
    private String receiverName;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String detailAddress;

    public AddressDTO() {
    }

    public AddressDTO(String receiverName, String detailAddress) {
        this.receiverName = receiverName;
        this.detailAddress = detailAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
}