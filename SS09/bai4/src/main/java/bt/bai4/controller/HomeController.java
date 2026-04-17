package bt.bai4.controller;

import bt.bai4.model.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("shop")
public class HomeController {

    @ModelAttribute("shop")
    public Shop initShop() {
        return new Shop();
    }

    @GetMapping("/customer-form")
    public String showFormCustomer(Model model) {
        return "customer-form";
    }

    @PostMapping("/save-customer")
    public String saveCustomer(@ModelAttribute("shop") Shop shop) {
        return "redirect:/shop-form";
    }

    @GetMapping("/shop-form")
    public String showFormShop() {
        return "shop-form";
    }

    @PostMapping("save-shop")
    public String saveShop(@ModelAttribute("shop") Shop shop) {
        return "redirect:/confirm";
    }

    @GetMapping("/confirm")
    public String showConfirm() {
        return "confirm";
    }

    @GetMapping("/accept")
    public String confirm(
            @ModelAttribute("shop") Shop shop,
            @RequestParam("status") String status,
            SessionStatus sessionStatus,
            Model model) {
        if (status.equals("accept")) {
            model.addAttribute("notification", "Tạo thành công");
            System.out.println("Lưu vào DB");
            System.out.println(shop.toString());
        } else {
            model.addAttribute("notification", "Huỷ thành công");
        }
        sessionStatus.setComplete();
        return "success";
    }
}
