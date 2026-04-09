package bt.ss05.bai2.controller;

import bt.ss05.bai2.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DishController {
    private DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/bai2/dish-list")
    public String viewList(Model model) {
        model.addAttribute("dishes", dishService.findAll());
        return "dish-list";
    }
}
