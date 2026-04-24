package employee.employeemanagement.controller;

import employee.employeemanagement.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/","employees"})
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "employee/list-employees";
    }

    @GetMapping("/{empId}")
    public String showEmployee(@PathVariable("empId") String empId, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(empId));
        return "employee/detail-employee";
    }
}
