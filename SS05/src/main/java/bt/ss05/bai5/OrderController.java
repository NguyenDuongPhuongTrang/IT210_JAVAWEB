package bt.ss05.bai5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    // Danh sách món ăn
    @GetMapping("/menu")
    public String showMenu(Model model) {
        model.addAttribute("dishes", service.getAllDishes());
        return "bai5/menu";
    }

    // Chi tiết món ăn
    @GetMapping("/order/{id}")
    public String order(@PathVariable("id") String id, Model model) {
        model.addAttribute("dish", service.getDishById(id));
        return "bai5/order";
    }
}
