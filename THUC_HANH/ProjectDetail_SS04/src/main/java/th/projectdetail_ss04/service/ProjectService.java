package th.projectdetail_ss04.service;

import th.projectdetail_ss04.model.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    Project findById(String projectId);
}
