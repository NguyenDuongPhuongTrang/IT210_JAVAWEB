package th.projectmember.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import th.projectmember.model.dto.ProjectMemberDTO;
import th.projectmember.model.entity.ProjectMember;
import th.projectmember.service.ProjectMemberService;
import th.projectmember.service.UploadFile;

@Controller
public class ProjectMemberController {

    private final ProjectMemberService service;
    private final UploadFile uploadFile;

    public ProjectMemberController(ProjectMemberService service,
                                   UploadFile uploadFile) {
        this.service = service;
        this.uploadFile = uploadFile;
    }


    @GetMapping("/")
    public String list(Model model,
                       @RequestParam(name = "keyword", required = false) String keyword,
                       @RequestParam(name = "position", required = false) String position) {

        model.addAttribute("members", service.search(keyword, position));
        return "list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("memberDTO", new ProjectMemberDTO());
        model.addAttribute("actionUrl", "/save");
        return "form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("memberDTO") ProjectMemberDTO dto,
                       BindingResult result,
                       Model model) {

        if (result.hasErrors()) {
            model.addAttribute("actionUrl", "/save"); // 🔥 BẮT BUỘC
            return "form";
        }

        ProjectMember member = new ProjectMember();
        member.setFullName(dto.getFullName());
        member.setEmail(dto.getEmail());
        member.setPosition(dto.getPosition());
        member.setExperienceYears(dto.getExperienceYears());

        String fileName = uploadFile.uploadToLocal(dto.getImageFile());
        member.setImageUrl(fileName);

        service.save(member);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        ProjectMember m = service.findById(id);
        if (m == null) {
            return "redirect:/";
        }

        ProjectMemberDTO dto = new ProjectMemberDTO();
        dto.setId(m.getId());
        dto.setFullName(m.getFullName());
        dto.setEmail(m.getEmail());
        dto.setPosition(m.getPosition());
        dto.setExperienceYears(m.getExperienceYears());
        dto.setImageUrl(m.getImageUrl());           // ← SỬA Ở ĐÂY

        model.addAttribute("memberDTO", dto);
        model.addAttribute("actionUrl", "/update");
        return "form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("memberDTO") ProjectMemberDTO dto,
                         @RequestParam(value = "imageFile", required = false) MultipartFile imageFile) {

        ProjectMember member = service.findById(dto.getId());
        if (member == null) {
            return "redirect:/";
        }

        member.setFullName(dto.getFullName());
        member.setEmail(dto.getEmail());
        member.setPosition(dto.getPosition());
        member.setExperienceYears(dto.getExperienceYears());

        // Chỉ thay ảnh khi người dùng upload file mới
        if (imageFile != null && !imageFile.isEmpty()) {
            String newImageUrl = uploadFile.uploadToLocal(imageFile);
            if (newImageUrl != null && !newImageUrl.isEmpty()) {
                member.setImageUrl(newImageUrl);
            }
        }
        // Không upload ảnh mới → giữ nguyên ảnh cũ

        service.update(member);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}