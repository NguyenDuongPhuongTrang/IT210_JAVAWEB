package upload.updateload_image.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class StudentDTO {
    private String stuId;
    private String fullName;
    private String className;
    private MultipartFile imageFile;

    public StudentDTO() {
    }

    public StudentDTO(String stuId, String fullName, String className, MultipartFile imageFile) {
        this.stuId = stuId;
        this.fullName = fullName;
        this.className = className;
        this.imageFile = imageFile;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
}
