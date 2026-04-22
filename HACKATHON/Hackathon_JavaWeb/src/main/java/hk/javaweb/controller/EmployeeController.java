package hk.javaweb.controller;

import hk.javaweb.model.dto.EmployeeDTO;
import hk.javaweb.model.entity.Employee;
import hk.javaweb.service.EmployeeService;
import hk.javaweb.service.UploadFile;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final UploadFile uploadFile;

    public EmployeeController(EmployeeService employeeService, UploadFile uploadFile) {
        this.employeeService = employeeService;
        this.uploadFile = uploadFile;
    }

    @GetMapping({"/", "/employees"})
    public String list(Model model,
                       @RequestParam(name = "keyword", required = false) String keyword,
                       @RequestParam(name = "position", required = false) String position) {
        model.addAttribute("employees", employeeService.search(keyword, position));
        return "employees";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("employeeDTO", new EmployeeDTO());
        model.addAttribute("actionUrl", "/save");
        return "form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employeeDTO") EmployeeDTO dto,
                       BindingResult result,
                       @RequestParam(value = "avatar", required = false) MultipartFile avatarFile,
                       Model model) {

        if (result.hasErrors()) {
            model.addAttribute("actionUrl", "/save");
            return "form";
        }

        Employee employee = new Employee();
        employee.setFullName(dto.getFullName());
        employee.setPosition(dto.getPosition());
        employee.setSalary(dto.getSalary());

        if (avatarFile != null && !avatarFile.isEmpty()) {
            String fileName = uploadFile.uploadToLocal(avatarFile);
            employee.setAvatarUrl(fileName);
        } else {
            employee.setAvatarUrl("/uploads/avatars/avatar-default.png");
        }

        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return "redirect:/";
        }

        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setFullName(employee.getFullName());
        dto.setPosition(employee.getPosition());
        dto.setSalary(employee.getSalary());
        dto.setAvatarUrl(employee.getAvatarUrl());

        model.addAttribute("employeeDTO", dto);
        model.addAttribute("actionUrl", "/update");
        return "form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("employeeDTO") EmployeeDTO dto,
                         @RequestParam(value = "avatar", required = false) MultipartFile avatarFile) {

        Employee employee = employeeService.findById(dto.getId());
        if (employee == null) {
            return "redirect:/";
        }

        employee.setFullName(dto.getFullName());
        employee.setPosition(dto.getPosition());
        employee.setSalary(dto.getSalary());

        if (avatarFile != null && !avatarFile.isEmpty()) {
            String newAvatarUrl = uploadFile.uploadToLocal(avatarFile);
            employee.setAvatarUrl(newAvatarUrl);
        }

        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        employeeService.delete(id);
        return "redirect:/";
    }
}