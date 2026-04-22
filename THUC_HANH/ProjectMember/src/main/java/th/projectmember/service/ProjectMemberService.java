package th.projectmember.service;

import th.projectmember.model.entity.ProjectMember;
import java.util.List;

public interface ProjectMemberService {
    List<ProjectMember> findAll();

    void save(ProjectMember m);

    ProjectMember findById(Long id);

    void update(ProjectMember m);

    void delete(Long id);

    List<ProjectMember> search(String keyword, String position);
}