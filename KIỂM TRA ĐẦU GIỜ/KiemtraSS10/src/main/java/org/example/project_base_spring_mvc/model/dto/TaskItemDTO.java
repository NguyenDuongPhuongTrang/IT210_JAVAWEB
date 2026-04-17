package org.example.project_base_spring_mvc.model.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class TaskItemDTO {
    @NotBlank(message = "Tiêu đề không được để trống")
    private String title;

    @NotNull(message = "Hạn chót không được để trống")
    @Future(message = "Hạn chót phải là một ngày trong tương lai")
    private LocalDate deadline;

    @NotNull(message = "Mức độ ưu tiên không được để trống")
    @Pattern( regexp = "LOW|MEDIUM|HIGH", message = "Mức độ ưu tiên phải là LOW, MEDIUM hoặc HIGH")
    private String priority;

    public TaskItemDTO() {
    }

    public TaskItemDTO(String title, LocalDate deadline, String priority) {
        this.title = title;
        this.deadline = deadline;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
