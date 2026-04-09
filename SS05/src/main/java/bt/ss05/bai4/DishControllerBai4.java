package bt.ss05.bai4;

import bt.ss05.bai3.service.AdminService;
import bt.ss05.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DishControllerBai4 {
    private AdminService dishService;

    public DishControllerBai4(AdminService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/dish")
    public String dish(Model model) {
        model.addAttribute("dishes", dishService.findAll());
        return "dishes";
    }

    @GetMapping("/dish/{id}")
    public String dishDetail(@PathVariable("id") String id,
                             Model model) {
        Dish dish = dishService.findById(id);
        model.addAttribute("item", dish);
        return "dish-detail";
    }
}