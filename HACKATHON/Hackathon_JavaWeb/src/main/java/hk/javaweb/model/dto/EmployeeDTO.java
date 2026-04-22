package hk.javaweb.model.dto;

import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;

public class EmployeeDTO {
    private String id;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 50, message = "Tên phải có độ dài từ 5 đến 50 ký tự")
    private String fullName;

    @NotEmpty(message = "Vị trí không được để trống")
    private String position;

    @NotNull(message = "Lương không được để trống")
    @Min(value = 0, message = "Lương phải lớn hơn hoặc bằng 0")
    @Digits(integer = 10, fraction = 2, message = "Lương phải là số thực")
    private Double salary;

    private MultipartFile avatar;
    private String avatarUrl;

    public EmployeeDTO(){}

    public EmployeeDTO(String id, String fullName, String position, Double salary, MultipartFile avatar, String avatarUrl) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.salary = salary;
        this.avatar = avatar;
        this.avatarUrl = avatarUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
