package ss07.bai5.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public String handleFileTooLarge(IllegalStateException ex, Model model) {

        if (ex.getMessage().contains("exceeds maximum size")) {
            model.addAttribute("error", "File quá lớn (>10MB)");
            return "error";
        }

        model.addAttribute("error", "Lỗi hệ thống");
        return "error";
    }
}
