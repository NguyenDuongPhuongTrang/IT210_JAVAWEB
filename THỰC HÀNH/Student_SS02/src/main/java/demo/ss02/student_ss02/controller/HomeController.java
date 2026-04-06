    package demo.ss02.student_ss02.controller;

    import demo.ss02.student_ss02.model.Student;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;

    import java.time.LocalDate;
    import java.util.ArrayList;
    import java.util.List;

    @Controller
    @RequestMapping({"/", "/home"})
    public class HomeController {
        private List<Student> students = new ArrayList<>();

        public HomeController() {
            students.add(new Student("ST001", "Doe", true, LocalDate.of(2000, 1, 1), "HCM", "SE1701"));
            students.add(new Student("ST002", "Jane", false, LocalDate.of(2001, 2, 2), "HN", "SE1702"));
            students.add(new Student("ST003", "John", true, LocalDate.of(2002, 3, 3), "SG", "SE1703"));
            students.add(new Student("ST004", "Marry", false, LocalDate.of(2003, 4, 4), "HCM", "SE1704"));
            students.add(new Student("ST005", "Peter", true, LocalDate.of(2004, 5, 5), "HN", "SE1705"));
        }

        @GetMapping
        public String home(Model model) {
            model.addAttribute("students", students);
            return "home";
        }
    }
