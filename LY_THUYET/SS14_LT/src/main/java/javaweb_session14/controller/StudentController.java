package javaweb_session14.controller;

import javaweb_session14.model.entity.Student;
import javaweb_session14.service.ClassService;
import javaweb_session14.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;

    @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("s",new Student());
        model.addAttribute("listClass", classService.getAllOnlyClasses());
        return "insertStudent";
    }

    @PostMapping("/add")
    public String doAddStudent(@ModelAttribute("s")Student s, Model model){
        boolean bl = studentService.insertStudent(s);
        if(bl){
            return "redirect:/classes";
        }else{
            model.addAttribute("error","Thêm mới sinh viên có lỗi");
            model.addAttribute("s",s);
            model.addAttribute("listClass", classService.getAllOnlyClasses());
            return "insertStudent";
        }
    }
}
