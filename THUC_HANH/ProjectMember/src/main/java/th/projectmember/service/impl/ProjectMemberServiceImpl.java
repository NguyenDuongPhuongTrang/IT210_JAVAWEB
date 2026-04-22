package th.projectmember.service.impl;

import org.springframework.stereotype.Service;
import th.projectmember.model.entity.ProjectMember;
import th.projectmember.repository.ProjectMemberRepository;
import th.projectmember.service.ProjectMemberService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final ProjectMemberRepository repo;

    public ProjectMemberServiceImpl(ProjectMemberRepository repo) {
        this.repo = repo;
    }

    public List<ProjectMember> findAll() {
        return repo.findAll();
    }

    public void save(ProjectMember m) {
        repo.save(m);
    }

    public ProjectMember findById(Long id) {
        return repo.findById(id);
    }

    public void update(ProjectMember m) {
        repo.update(m);
    }

    public void delete(Long id) {
        repo.delete(id);
    }

    public List<ProjectMember> search(String keyword, String position) {
        return repo.findAll().stream()
                .filter(m -> (keyword == null || m.getFullName().toLowerCase().contains(keyword.toLowerCase())
                        || m.getEmail().toLowerCase().contains(keyword.toLowerCase())))
                .filter(m -> (position == null || position.isEmpty() || m.getPosition().equals(position)))
                .collect(Collectors.toList());
    }
}
