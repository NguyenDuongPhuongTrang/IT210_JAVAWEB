package ss07.bai3.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class FoodDTO {
    private String name;
    private String category;
    private Double price;
    private MultipartFile image;

    public FoodDTO() {
    }

    public FoodDTO(String name, String category, Double price, MultipartFile image) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
