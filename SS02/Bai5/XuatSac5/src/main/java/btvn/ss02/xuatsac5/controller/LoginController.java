package btvn.ss02.xuatsac5.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(@RequestParam(name = "username", required = false) String username,
                        @RequestParam(name = "password", required = false) String password,
                        HttpSession session,
                        Model model) {
        if (username.equals("hr_manager") && password.equals("hr123") ||
                username.equals("hr_staff") && password.equals("staff456")) {

            // Lưu người dùng hiện tại
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            return "redirect:/employees";
        }
        model.addAttribute("error", "Thông tin đăng nhập không chính xác");
        return "login";
    }
}
