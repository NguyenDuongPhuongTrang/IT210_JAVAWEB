package org.example.project_base_spring_mvc.controller;

import jakarta.validation.Valid;
import org.example.project_base_spring_mvc.model.dto.TaskItemDTO;
import org.example.project_base_spring_mvc.model.entity.TaskItem;
import org.example.project_base_spring_mvc.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TaskController {
    private TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping({"/tasks", "/"})
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "task-list";
    }

    @GetMapping("/tasks/form")
    public String showAddTaskForm(Model model) {
        model.addAttribute("task", new TaskItem());
        return "task-form";
    }

    @PostMapping("/add")
    public String saveTaskItem(
            @Valid @ModelAttribute("taskItem") TaskItemDTO taskItemDTO,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("taskItem", taskItemDTO);
            return "task-form";
        }

        taskService.save(taskItemDTO);
        redirectAttributes.addFlashAttribute("notification", "Thêm thành công");
        return "redirect:/tasks";
    }
}
