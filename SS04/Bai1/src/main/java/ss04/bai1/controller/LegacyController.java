package ss04.bai1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ss04.bai1.service.OrderService;

@Controller
@RequestMapping("/bai1/orders")
public class LegacyController {

    private final OrderService orderService;

    @Autowired
    public LegacyController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @ResponseBody
    public String getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // Thêm demo POST cho đúng yêu cầu
    @PostMapping
    @ResponseBody
    public String createOrder() {
        return "Tao don hang moi thanh cong";
    }
}