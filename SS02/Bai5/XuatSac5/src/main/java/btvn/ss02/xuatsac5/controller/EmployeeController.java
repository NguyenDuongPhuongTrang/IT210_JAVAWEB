package btvn.ss02.xuatsac5.controller;


import btvn.ss02.xuatsac5.model.Employee;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController {
    private List<Employee> list = new ArrayList<>();

    public EmployeeController() {
        list.add(new Employee("NV001", "Nguyễn Hồng Anh", "Kế toán", 15_000_000, new Date(2020, 2, 1), "Đang làm"));
        list.add(new Employee("NV002", "Trần Việt An", "Kỹ thuật", 25_000_000, new Date(2019, 6, 15), "Đang làm"));
        list.add(new Employee("NV003", "Lê Hải Minh", "Kinh doanh", 18_500_000, new Date(2021, 10, 20), "Nghỉ phép"));
        list.add(new Employee("NV004", "Nguyễn Thu Hương", "Kỹ thuật", 22_000_000, new Date(2022, 0, 5), "Đang làm"));
        list.add(new Employee("NV005", "Hoàng Việt Tiến", "Kế toán", 12_000_000, new Date(2023, 5, 10), "Thử việc"));
    }

    @GetMapping("/employees")
    public String employees(Model model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        model.addAttribute("list", list);
        return "employees";
    }

    @GetMapping("/detail/{code}")
    public String employeeDetail(@PathVariable("code") String code,
                                 HttpSession session,
                                 Model model) {

        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        Employee employee = list.stream()
                .filter(e -> e.getId().equals(code))
                .findFirst()
                .orElse(null);
        model.addAttribute("employee", employee);
        return "detail";
    }
}
