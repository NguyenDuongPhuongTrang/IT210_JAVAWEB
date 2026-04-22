package th.projectdetail_ss04.repository.impl;

import org.springframework.stereotype.Repository;
import th.projectdetail_ss04.model.entity.Project;
import th.projectdetail_ss04.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {
    List<Project> projects = new ArrayList<>();

    public ProjectRepositoryImpl() {
        projects.add(new Project("P001", "Website Bán Hàng", "Xây dựng website thương mại điện tử", "Nguyễn Văn A", "2024-01-01", "2024-03-30", "5"));
        projects.add(new Project("P002", "App Mobile Banking", "Phát triển ứng dụng ngân hàng", "Trần Thị B", "2024-02-01", "2024-06-01", "8"));
        projects.add(new Project("P003", "Hệ thống Quản lý Sinh viên", "Quản lý thông tin sinh viên", "Lê Văn C", "2024-01-15", "2024-04-15", "4"));
        projects.add(new Project("P004", "Website Tin Tức", "Trang web đọc báo online", "Phạm Thị D", "2024-03-01", "2024-05-30", "3"));
        projects.add(new Project("P005", "App Giao Hàng", "Ứng dụng đặt và giao đồ ăn", "Hoàng Văn E", "2024-02-20", "2024-07-01", "7"));
        projects.add(new Project("P006", "CRM System", "Quản lý khách hàng cho doanh nghiệp", "Vũ Thị F", "2024-01-10", "2024-05-10", "6"));
        projects.add(new Project("P007", "Website Du Lịch", "Đặt tour và khách sạn online", "Đặng Văn G", "2024-04-01", "2024-08-01", "5"));
        projects.add(new Project("P008", "Hệ thống ERP", "Quản lý tài nguyên doanh nghiệp", "Bùi Thị H", "2024-02-15", "2024-09-01", "10"));
        projects.add(new Project("P009", "App Fitness", "Theo dõi sức khỏe và tập luyện", "Đỗ Văn I", "2024-03-10", "2024-06-20", "4"));
        projects.add(new Project("P010", "Website Giáo Dục", "Nền tảng học online", "Ngô Thị K", "2024-01-05", "2024-04-25", "6"));
    }

    @Override
    public List<Project> findAll() {
        return projects;
    }

    @Override
    public Project findById(String projectId) {
        return projects.stream()
                .filter(project -> project.getProjectId().equals(projectId))
                .findFirst()
                .orElse(null);
    }
}
