package bt.bai2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(
            @CookieValue(value = "guest_name", required = false) String guestName,
            Model model
    ) {
        if (guestName == null) {
            model.addAttribute("msg", "Xin chào khách lạ");
        } else {
            model.addAttribute("msg", "Chào mừng " + guestName + " trở lại");
        }
        return "home";
    }
}