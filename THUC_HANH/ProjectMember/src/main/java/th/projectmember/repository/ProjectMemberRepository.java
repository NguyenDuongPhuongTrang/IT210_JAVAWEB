package th.projectmember.repository;

import org.springframework.stereotype.Repository;
import th.projectmember.model.entity.ProjectMember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProjectMemberRepository {

    private final Map<Long, ProjectMember> data = new HashMap<>();
    private Long idCounter = 1L;

    public List<ProjectMember> findAll() {
        return new ArrayList<>(data.values());
    }

    public void save(ProjectMember member) {
        member.setId(idCounter++);
        data.put(member.getId(), member);
    }

    public ProjectMember findById(Long id) {
        return data.get(id);
    }

    public void update(ProjectMember member) {
        data.put(member.getId(), member);
    }

    public void delete(Long id) {
        data.remove(id);
    }
}