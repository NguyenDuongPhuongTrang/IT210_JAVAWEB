package bt.btap2504.controller;

import bt.btap2504.model.dto.TodoDTO;
import bt.btap2504.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public String listTodos(Model model) {
        model.addAttribute("todos", todoService.findAll());
        return "todo";
    }

    @GetMapping("/add-todo")
    public String showAddTodoForm(Model model) {
        model.addAttribute("todo", new TodoDTO());
        return "todoForm";
    }

    @PostMapping("/add-todo")
    public String addToDo(
            @Valid @ModelAttribute("todo") TodoDTO todoDTO,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "todoForm";
        }
        todoService.addToDo(todoDTO);
        return "redirect:/todo";
    }
}