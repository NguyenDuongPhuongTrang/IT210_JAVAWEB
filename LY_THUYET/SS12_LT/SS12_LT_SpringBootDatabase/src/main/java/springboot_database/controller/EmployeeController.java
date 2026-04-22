package springboot_database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot_database.model.entity.Employee;
import springboot_database.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("list",employeeService.getEmployees());
        return "listEmployees";
    }

    @GetMapping("/add-employee")
    public String addEmployee(Model model){
        model.addAttribute("employee",new Employee());
        return "insertEmployee";
    }

    @PostMapping("/add-employee")
    public String doAddEmployee(@ModelAttribute("employee")Employee employee, Model model){
        Employee emp = employeeService.insertEmployee(employee);
        if(emp!=null){
            return "redirect:/employees";
        }else{
            model.addAttribute("error","Thêm mới nhân viên không thành công");
            model.addAttribute("employee",employee);
            return "insertEmployee";
        }
    }
}
