package bt.ss05.bai3.controller;

import bt.ss05.bai3.service.AdminService;

import bt.ss05.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/bai3/edit/{id}")
    public String showFormEdit(@PathVariable("id") String id,
                               Model model) {
        Dish dish = adminService.findById(id);
        if (dish == null) {
            model.addAttribute("error", "Dish not found");
            return "redirect:/bai3/dish-list";
        }
        model.addAttribute("dish", dish);
        return "edit-dish";
    }

    @PostMapping("/bai3/update")
    public String editDish(@ModelAttribute("dish") Dish dish,
                           Model model) {
        adminService.updateDish(dish);
        return "redirect:/bai2/dish-list";
    }

}
