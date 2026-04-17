package org.example.project_base_spring_mvc.repository;

import org.example.project_base_spring_mvc.model.entity.TaskItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private List<TaskItem> tasks = new ArrayList<>();

    public TaskRepository() {
        tasks.add(new TaskItem("1", "Học Spring MVC", java.time.LocalDate.now().plusDays(7), "HIGH"));
        tasks.add(new TaskItem("2", "Học Java", java.time.LocalDate.now().plusDays(14), "MEDIUM"));
        tasks.add(new TaskItem("3", "Học JavaScript", java.time.LocalDate.now().plusDays(21), "LOW"));
        tasks.add(new TaskItem("4", "Học Python", java.time.LocalDate.now().plusDays(28), "MEDIUM"));
        tasks.add(new TaskItem("5", "Học React", java.time.LocalDate.now().plusDays(35), "HIGH"));
        tasks.add(new TaskItem("6", "Học Angular", java.time.LocalDate.now().plusDays(42), "LOW"));
    }

    public List<TaskItem> findAll() {
        return tasks;
    }

}
