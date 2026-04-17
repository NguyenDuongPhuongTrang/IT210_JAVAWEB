package bt.bai3.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThemeController {
    @PostMapping("/change-theme")
    public String changeTheme(
            @RequestParam(value = "theme", required = false) String theme,
            HttpServletResponse response
    ) {
        Cookie cookie = new Cookie("theme", theme);
        cookie.setMaxAge(30 * 24 * 60 * 60);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return "redirect:/";
    }

    @GetMapping("/")
    public String theme(
            @CookieValue(value = "theme", defaultValue = "white") String theme,
            Model model) {
        model.addAttribute("theme", theme);
        return "theme";
    }
}