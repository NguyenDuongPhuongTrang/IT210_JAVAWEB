package ss07.bai4.controller;

import ss07.bai4.model.dto.FoodDTO;
import ss07.bai4.model.entity.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/food")
public class Bai4Controller {

    @GetMapping
    public String formAddFood(Model model) {
        model.addAttribute("foodDTO", new FoodDTO());
        return "form-add";
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

        String newFileName = UUID.randomUUID().toString() + image.getOriginalFilename();
        File dest = new File(uploadDir + newFileName);
        image.transferTo(dest);
        return "/images/" + newFileName;

    }

    @PostMapping("/add")
    public String addFood(@ModelAttribute("foodDTO") FoodDTO foodDTO,
                          RedirectAttributes redirectAttributes) {
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
        redirectAttributes.addFlashAttribute("food", food);
        redirectAttributes.addFlashAttribute("message", "Thêm món ăn thành công");
        return "redirect:/food/food-detail";
    }

    @GetMapping("/food-detail")
    public String viewFoodDetail(Model model) {
        return "food-detail";
    }
}