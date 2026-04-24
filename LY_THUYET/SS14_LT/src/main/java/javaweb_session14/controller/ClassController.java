package javaweb_session14.controller;

import javaweb_session14.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping
    public String listClasses(Model model){
        model.addAttribute("listClasses",classService.getClasses());
        return "listClasses";
    }
}
