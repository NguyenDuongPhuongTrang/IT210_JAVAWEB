package ss07.bai2.controller;

import ss07.bai2.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/*
    Code gốc vi phạm nguyên tắc DRY
    Nếu mở rộng sẽ gây khó bảo trì, các phần có thể không đồng nhất, code khó đọc
*/

@Controller("Bai2Controller")
@RequestMapping("/merchant/dish")
public class DishController {
    private List<String> categories = Arrays.asList("Món chính", "Đồ uống", "Tráng miệng", "Topping");

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("categories", categories);
        model.addAttribute("dish", new Dish());
        return "dish-add";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model) {
        model.addAttribute("categories", categories);
        model.addAttribute("dish", new Dish("Trà sữa", "Đồ uống"));
        return "dish-edit";
    }

    @GetMapping("/search")
    public String showSearchPage(Model model) {
        model.addAttribute("categories", categories);
        return "dish-search";
    }
}