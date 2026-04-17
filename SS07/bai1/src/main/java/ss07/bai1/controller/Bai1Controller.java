package ss07.bai1.controller;

import ss07.bai1.model.RestaurantProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
- Nguyên nhân khiến tên của món bị null là do tên biến trong class không trùng với thuộc tính name của thẻ input,
nên dữ liệu từ form không bind được vào object.
- Checkbox không hoạt động như mong muốn vì khi không được chọn (unchecked), nó sẽ không gửi giá trị về server,
dẫn đến phía backend không nhận được dữ liệu.
*/

@Controller
@RequestMapping("/")
public class Bai1Controller {
    private RestaurantProfile data = new RestaurantProfile();

    @GetMapping
    public String viewRestaurant(Model model) {
        model.addAttribute("restaurant", new RestaurantProfile());
        return "restaurant";
    }

    @PostMapping("/save")
    public String saveRestaurant(@ModelAttribute("restaurant") RestaurantProfile restaurantProfile) {
        data.setName(restaurantProfile.getName());
        data.setPhone(restaurantProfile.getPhone());
        data.setActive(restaurantProfile.isActive());
        return "redirect:/restaurant-detail";
    }

    @GetMapping("/restaurant-detail")
    public String viewRestaurantDetail(Model model) {
        model.addAttribute("data", data);
        return "restaurant-detail";
    }
}
