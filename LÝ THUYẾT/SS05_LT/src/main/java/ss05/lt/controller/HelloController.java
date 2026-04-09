package ss05.lt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/hello", "/"})
public class HelloController {
    @GetMapping
    public String sayHello(Model model) {
        model.addAttribute("message", "Hello, Spring MVC with Thymeleaf!");
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Spring");
        list.add("Thymeleaf");
        model.addAttribute("list", list);
        return "home";
    }
}
