package ss07.bai3.controller;

import ss07.bai3.model.entity.Food;
import ss07.bai3.model.dto.FoodDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/foods")
public class Bai3Controller {
    private List<Food> foods = new ArrayList<>();

    @GetMapping
    public String showFood(Model model) {
        model.addAttribute("foods", foods);
        return "foods";
    }

    @GetMapping("/add")
    public String showAddFood(Model model) {
        model.addAttribute("foodDTO", new FoodDTO());
        return "food-add";
    }

    private String uploadImage(MultipartFile image) throws IOException {
        if (image.isEmpty()) {
            return null;
        }
        String tail = image.getOriginalFilename().split("\\.")[1];
        if (!tail.equals("png") && !tail.equals("jpg") && !tail.equals("jpeg")) {
            return null;
        }

        String uploadDir = "C:/RikkeiFood_Temp/";
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdir();
        }

        File dest = new File(uploadDir + image.getOriginalFilename());
        image.transferTo(dest);
        return "/images/" + image.getOriginalFilename();
    }

    @PostMapping("/add")
    public String addFood(@ModelAttribute("foodDTO") FoodDTO foodDTO, Model model) {
        String imageUrl;
        try {
            imageUrl = uploadImage(foodDTO.getImage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Food food = new Food();
        food.setName(foodDTO.getName());
        food.setCategory(foodDTO.getCategory());
        food.setPrice(foodDTO.getPrice());
        food.setImageUrl(imageUrl);
        if (foodDTO.getPrice() != null && foodDTO.getPrice() > 0 && imageUrl != null) {
            foods.add(food);
        }
        System.out.println(food.toString());
        System.out.println("Tổng món ăn: " + foods.size());
        return "redirect:/foods";
    }
}
