package btvn.ss02.gioi3.controller;

import btvn.ss02.gioi3.model.Order;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String orders(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("DH001", "Laptop", 15000000, new Date()));
        orders.add(new Order("DH002", "Điện thoại", 8000000, new Date()));
        orders.add(new Order("DH003", "Tai nghe", 1200000, new Date()));

        model.addAttribute("orders", orders);
        model.addAttribute("username", session.getAttribute("loggedUser"));
        model.addAttribute("role", session.getAttribute("role"));

        ServletContext application = request.getServletContext();
        synchronized(application) { // tránh Race Condition
            Integer totalViewCount = (Integer) application.getAttribute("totalViewCount");
            if(totalViewCount == null) totalViewCount = 0;
            totalViewCount++;
            application.setAttribute("totalViewCount", totalViewCount);
        }

        model.addAttribute("totalViewCount", application.getAttribute("totalViewCount"));

        return "orders";
    }
}