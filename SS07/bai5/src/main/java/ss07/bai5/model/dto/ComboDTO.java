package ss07.bai5.model.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ComboDTO {
    private String name;
    private List<String> items;
    private MultipartFile file;

    public ComboDTO() {
    }

    public ComboDTO(String name, List<String> items, MultipartFile file) {
        this.name = name;
        this.items = items;
        this.file = file;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
