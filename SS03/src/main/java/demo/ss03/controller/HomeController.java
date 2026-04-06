package demo.ss03.controller;

import demo.ss03.enums.StudentStatus;
import demo.ss03.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class HomeController {

    private final List<Student> students = new ArrayList<>();

    public HomeController() {
        // Dữ liệu mẫu
        students.add(new Student(1, "Nguyễn Văn An", "SV001", "Công nghệ thông tin", 2021, 3.2, StudentStatus.STUDYING));
        students.add(new Student(2, "Lê Văn Cường", "SV002", "Cơ khí", 2019, 2.8, StudentStatus.GRADUATED));
        students.add(new Student(3, "Phan Văn Minh", "SV003", "Xây dựng", 2025, 2.6, StudentStatus.STUDYING));
        students.add(new Student(4, "Võ Thị Hoa", "SV004", "Luật", 2025, 3.4, StudentStatus.STUDYING));
        students.add(new Student(5, "Phạm Thị Dung", "SV005", "Quản trị kinh doanh", 2022, 3.9, StudentStatus.RESERVED));
        students.add(new Student(6, "Bùi Thị Lan", "SV006", "Y dược", 2024, 3.7, StudentStatus.RESERVED));
        students.add(new Student(7, "Hoàng Văn Em", "SV007", "Điện - Điện tử", 2023, 2.5, StudentStatus.STUDYING));
        students.add(new Student(8, "Trần Thị Bình", "SV008", "Kinh tế", 2020, 3.6, StudentStatus.GRADUATED));
        students.add(new Student(9, "Đặng Văn Khánh", "SV009", "Công nghệ thông tin", 2018, 2.9, StudentStatus.GRADUATED));
        students.add(new Student(10, "Ngô Thị Nga", "SV010", "Du lịch", 2021, 3.8, StudentStatus.GRADUATED));
    }

    @GetMapping({"/", "/home"})
    public String getStudents(@RequestParam(value = "sortBy", required = false) String sortBy,
                              Model model) {

        List<Student> sortedStudents = new ArrayList<>(students);

        // SẮP XẾP
        if (sortBy != null) {
            switch (sortBy.toLowerCase()) {
                case "name":
                    sortedStudents.sort(Comparator.comparing(Student::getNameOnly));
                    break;
                case "gpa":
                    sortedStudents.sort(Comparator.comparingDouble(Student::getGpa).reversed());
                    break;
                default:
                    break;
            }
        }

        //LỌC DỮ LIỆU


        model.addAttribute("students", sortedStudents);
        model.addAttribute("currentSort", sortBy);
        return "home";
    }

    @GetMapping("/home/detail")
    public String studentDetail(@RequestParam("id") int id, Model model) {

        Student student = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        if (student == null) {
            return "home";
        }

        model.addAttribute("s", student);
        return "studentDetail";
    }
}