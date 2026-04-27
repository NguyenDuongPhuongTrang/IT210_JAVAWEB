package bt.btap2604.controller;

import bt.btap2604.model.dto.TodoDTO;
import bt.btap2604.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo")
    public String listTodos(Model model) {
        model.addAttribute("todos", todoService.findAll());
        return "todo";
    }

    @GetMapping("/add-todo")
    public String showAddTodoForm(Model model) {
        model.addAttribute("todo", new TodoDTO());
        return "todoForm";
    }

    @GetMapping("/todo/edit/{id}")
    public String showEditTodoForm(Model model, @PathVariable Long id) {
        model.addAttribute("todo", todoService.findById(id));
        return "todoForm";
    }

    @PostMapping("/add-todo")
    public String addToDo(
            @Valid @ModelAttribute("todo") TodoDTO todoDTO,
            BindingResult bindingResult,
            @RequestParam(value = "id", required = false) Long id
    ) {
        if (bindingResult.hasErrors()) {
            return "todoForm";
        }
        if (id == null) {
            todoService.addToDo(todoDTO);
        } else {
            todoService.updateTodo(id, todoDTO);
        }
        return "redirect:/todo";
    }

    @GetMapping("/delete")
    public String deleteTodo(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        todoService.deleteTodo(id);
        redirectAttributes.addFlashAttribute("message", "Xóa todo thành công");
        return "redirect:/todo";
    }
}