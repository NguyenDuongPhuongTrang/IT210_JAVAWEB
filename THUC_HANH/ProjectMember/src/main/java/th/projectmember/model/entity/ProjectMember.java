package th.projectmember.model.entity;

public class ProjectMember {
    private Long id;
    private String fullName;
    private String position;
    private Double experienceYears;
    private String email;
    private String imageUrl;

    public ProjectMember() {
    }

    public ProjectMember(Long id, String fullName, String position, Double experienceYears, String email, String imageUrl) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.experienceYears = experienceYears;
        this.email = email;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
