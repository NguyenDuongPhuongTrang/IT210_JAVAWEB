package ss04.bai5.controller;

import ss04.bai5.model.Order;
import ss04.bai5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("bai5OrderControler")
@RequestMapping("/bai5")
public class OrderController {
    public OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "orders";
    }

    @GetMapping("/orders/{id}")
    public String orderDetail(@PathVariable("id") String id, Model model) {
        try {
            Integer orderId = Integer.parseInt(id);
            Order order = orderService.findById(orderId);
            if (order == null) {
                return "Không tìm thấy đơn hàng";
            }
            model.addAttribute("order", order);
        } catch (NumberFormatException e) {
            return "Không tìm thấy đơn hàng";
        }
        return "order-detail";
    }

    @PostMapping
    public String createOrder(@RequestBody Order order) {
        return "Tạo đơn hàng thành công";
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@RequestParam("id") int id) {
        return "Xóa đơn hàng thành công";
    }
}
