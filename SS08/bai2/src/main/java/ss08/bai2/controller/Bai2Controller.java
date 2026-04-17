package ss08.bai2.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ss08.bai2.model.EmployeeDto;

//Sai ở thứ tự tham số
//Trong Spring:
//BindingResult phải đứng ngay sau object có @Valid, nếu không → Spring không bind lỗi vào BindingResult
//và nó sẽ ném thẳng MethodArgumentNotValidException, dẫn tới 400 Bad Request
@Controller
@RequestMapping("/hr")
public class Bai2Controller {

    @GetMapping("/add-employee")
    public String showForm(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        return "employee-form";
    }

    @PostMapping("/add-employee")
    public String saveEmployee(@Valid @ModelAttribute("employee") EmployeeDto employee,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            return "employee-form";
        }

        model.addAttribute("message", "Them nhan vien thanh cong: " + employee.getFullName());
        model.addAttribute("employee", new EmployeeDto());
        return "employee-form";
    }
}