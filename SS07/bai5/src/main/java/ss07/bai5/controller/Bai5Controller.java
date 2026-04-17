package ss07.bai5.controller;

import ss07.bai5.model.entity.Combo;
import ss07.bai5.model.dto.ComboDTO;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/combo")
public class Bai5Controller {
    private List<Combo> comboList = new ArrayList<>();

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("comboDTO", new ComboDTO());
        return "combo-form";
    }

    @PostMapping("/add")
    public String addCombo(@ModelAttribute("comboDTO") ComboDTO comboDTO,
                           RedirectAttributes redirectAttributes) {

        if (comboDTO.getItems() == null || comboDTO.getItems().size() < 2) {
            redirectAttributes.addFlashAttribute("error", "Phải chọn ít nhất 2 món");
            return "redirect:/combo";
        }

        String fileName = null;
        try {
            MultipartFile file = comboDTO.getFile();
            if (file != null && !file.isEmpty()) {
                String uploadDir = "C:/combo_upload/";
                File dir = new File(uploadDir);
                if (!dir.exists()) dir.mkdir();

                fileName = UUID.randomUUID() + file.getOriginalFilename();
                file.transferTo(new File(uploadDir + fileName));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Combo combo = new Combo();
        combo.setName(comboDTO.getName());
        combo.setItems(comboDTO.getItems());
        combo.setUrlImage(fileName);

        comboList.add(combo);

        System.out.println(combo);

        redirectAttributes.addFlashAttribute("message", "Tạo combo thành công");
        return "redirect:/combo";
    }
}