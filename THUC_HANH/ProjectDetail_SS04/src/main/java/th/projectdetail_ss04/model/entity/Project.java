package th.projectdetail_ss04.model.entity;

public class Project {
    private String projectId;
    private String projectName;
    private String projectDescription;
    private String projectManager;
    private String projectStartDate;
    private String projectEndDate;
    private String totalPersonnel;

    public Project() {
    }

    public Project(String projectId, String projectName, String projectDescription, String projectManager, String projectStartDate, String projectEndDate, String totalPersonnel) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectManager = projectManager;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.totalPersonnel = totalPersonnel;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(String projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public String getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(String projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public String getTotalPersonnel() {
        return totalPersonnel;
    }

    public void setTotalPersonnel(String totalPersonnel) {
        this.totalPersonnel = totalPersonnel;
    }
}
