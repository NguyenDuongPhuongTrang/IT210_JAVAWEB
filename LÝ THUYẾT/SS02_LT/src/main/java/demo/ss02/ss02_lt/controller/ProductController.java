package demo.ss02.ss02_lt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "/products"})
public class ProductController {
    @GetMapping String home(Model model) {
        model.addAttribute("name", "Phương Trang");
        return "listProducts";
    }

    @GetMapping("/jstl")
    public String jstl() {
        return "Jstl";
    }
}
