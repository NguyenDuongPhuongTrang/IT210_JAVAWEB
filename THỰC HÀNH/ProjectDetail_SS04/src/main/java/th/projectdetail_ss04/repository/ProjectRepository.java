package th.projectdetail_ss04.repository;

import th.projectdetail_ss04.model.entity.Project;

import java.util.List;

public interface ProjectRepository {
    List<Project> findAll();
    Project findById(String projectId);
}
