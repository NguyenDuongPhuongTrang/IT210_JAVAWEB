package ss04.bai4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai4")
public class ProductController {

    @GetMapping("/products")
    public String getProducts(
            @RequestParam("category") String category,
            @RequestParam("limit") Integer limit,
            ModelMap modelMap
    ) {
        modelMap.addAttribute("category", category)
                .addAttribute("limit", limit)
                .addAttribute("message", "Tìm kiếm thành công");

        return "productList";
    }
}
