package th.projectdetail_ss04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import th.projectdetail_ss04.service.ProjectService;
import th.projectdetail_ss04.service.impl.ProjectServiceImpl;

@Controller
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping({"/", "/projects"})
    public String listProjects(Model model) {
        model.addAttribute("projects", projectService.findAll());
        return "project/project-list";
    }

    @GetMapping("/projects/{projectId}")
    public String showProjectDetails(@PathVariable("projectId") String projectId, Model model) {
        model.addAttribute("projectId", projectId);
        return "project/project-details";
    }
}
