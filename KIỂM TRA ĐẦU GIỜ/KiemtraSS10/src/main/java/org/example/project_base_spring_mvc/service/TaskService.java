package org.example.project_base_spring_mvc.service;

import org.example.project_base_spring_mvc.model.dto.TaskItemDTO;
import org.example.project_base_spring_mvc.model.entity.TaskItem;
import org.example.project_base_spring_mvc.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskItem> findAll() {
        return taskRepository.findAll();
    }

    private TaskItem mapToTaskItem(TaskItemDTO taskItemDTO) {
        return new TaskItem(
                UUID.randomUUID().toString(),
                taskItemDTO.getTitle(),
                taskItemDTO.getDeadline(),
                taskItemDTO.getPriority()
        );
    }

    public void save(TaskItemDTO taskItemDTO) {
        TaskItem taskItem = mapToTaskItem(taskItemDTO);
        taskRepository.findAll().add(taskItem);
    }
}
