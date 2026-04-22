package th.projectmember.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public class ProjectMemberDTO{
    private Long id;
    @NotBlank
    @Size(min = 5, max = 50)
    private String fullName;

    private String position;

    @PositiveOrZero
    private Double experienceYears;

    @Email
    private String email;

    private MultipartFile imageFile;
    private String imageUrl;

    public ProjectMemberDTO() {
    }

    public ProjectMemberDTO(Long id, String fullName, String position, Double experienceYears, String email, MultipartFile imageFile, String imageUrl) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.experienceYears = experienceYears;
        this.email = email;
        this.imageFile = imageFile;
        this.imageUrl = imageUrl;
    }

    public ProjectMemberDTO(Long id, String fullName, String position, Double experienceYears, String email, MultipartFile imageFile) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.experienceYears = experienceYears;
        this.email = email;
        this.imageFile = imageFile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Double getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Double experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

