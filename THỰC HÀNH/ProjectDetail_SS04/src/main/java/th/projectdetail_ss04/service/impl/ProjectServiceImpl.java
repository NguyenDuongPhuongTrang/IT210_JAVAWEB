package th.projectdetail_ss04.service.impl;

import org.springframework.stereotype.Service;
import th.projectdetail_ss04.model.entity.Project;
import th.projectdetail_ss04.repository.ProjectRepository;
import th.projectdetail_ss04.service.ProjectService;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(String projectId) {
        return projectRepository.findById(projectId);
    }
}
