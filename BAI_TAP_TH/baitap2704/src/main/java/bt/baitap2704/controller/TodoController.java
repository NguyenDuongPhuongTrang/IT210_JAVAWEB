package bt.baitap2704.controller;

import bt.baitap2704.model.dto.TodoDTO;
import bt.baitap2704.service.TodoService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

@Controller
public class TodoController {
    private final TodoService todoService;
    private final MessageSource messageSource;

    public TodoController(TodoService todoService, MessageSource messageSource) {
        this.todoService = todoService;
        this.messageSource = messageSource;
    }

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }

    @PostMapping("/save-name")
    public String saveName(@RequestParam String name, HttpSession session) {
        if (name == null || name.trim().isEmpty()) {
            return "welcome";
        }
        session.setAttribute("ownerName", name);
        return "redirect:/todo";
    }

    @GetMapping("/todo")
    public String listTodos(Model model, HttpSession session) {

        String ownerName = (String) session.getAttribute("ownerName");

        if (ownerName == null) {
            return "redirect:/";
        }

        model.addAttribute("ownerName", ownerName);
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
    public String deleteTodo(@RequestParam("id") Long id,
                             RedirectAttributes redirectAttributes,
                             Locale locale) {
        todoService.deleteTodo(id);
        String msg = messageSource.getMessage("message.delete.success", null, locale);
        redirectAttributes.addFlashAttribute("message", msg);
        return "redirect:/todo";
    }
}