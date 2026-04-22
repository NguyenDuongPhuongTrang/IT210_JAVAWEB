package bt.bai5.controller;

import bt.bai5.model.Doctor;
import bt.bai5.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Value("${hospital.name}")
    private String hospitalName;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("doctors", doctorService.getAll());
        model.addAttribute("hospitalName", hospitalName);
        return "doctors";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Doctor doctor) {
        doctorService.addDoctor(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/search")
    public String search(@RequestParam String phone, Model model) {
        model.addAttribute("doctors", doctorService.searchByPhone(phone));
        return "doctors";
    }
}