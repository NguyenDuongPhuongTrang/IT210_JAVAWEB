package ss07.bai5.model.entity;

import java.util.List;

public class Combo {
    private String name;
    private List<String> items;
    private String urlImage;

    public Combo() {
    }

    public Combo(String name, List<String> items, String urlImage) {
        this.name = name;
        this.items = items;
        this.urlImage = urlImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
