package bt.bai4.controller;

import bt.bai4.service.MedicineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedicineController {
    private MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping("/medicines")
    public String showMedicine(Model model) {
        model.addAttribute("medicines", medicineService.findMedicineBeforeExpiryDate());
        return "medicines";
    }
}
