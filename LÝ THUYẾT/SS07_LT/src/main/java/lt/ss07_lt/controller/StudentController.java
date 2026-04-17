package lt.ss07_lt.controller;

import lt.ss07_lt.model.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/students")
public class StudentController {
    @GetMapping("/add")
    public String addStudent(Model model) {
//        model.addAttribute("student", new Student());
        Student s = new Student(10, "Nguyen Van A", "Nam", new Date());
        model.addAttribute("student", s);
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student, Model model) {
        model.addAttribute("student", student);
        return "views-student";
    }
}
