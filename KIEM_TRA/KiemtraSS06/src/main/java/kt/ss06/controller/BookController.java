package kt.ss06.controller;

import kt.ss06.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({"/book", "/"})
    public String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book";
    }

    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", bookService.findById(id));
        return "detail";
    }
}
