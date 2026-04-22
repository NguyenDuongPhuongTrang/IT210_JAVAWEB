package upload.updateload_image.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upload.updateload_image.model.dto.StudentDTO;
import upload.updateload_image.model.entity.Student;
import upload.updateload_image.service.UploadImage;

@Controller
@RequestMapping("/students")
public class StudentController {
    private UploadImage uploadImage;
    public StudentController(UploadImage uploadImage) {
        this.uploadImage = uploadImage;
    }

    @GetMapping("/add")
    public String addStudent(Model model) {
        model.addAttribute("studentDTO", new StudentDTO());
        return "add-student";
    }

    @PostMapping("/add")
    public String doAddStudent(@ModelAttribute("studentDTO")StudentDTO studentDTO, Model model) {
        Student student = new Student();
        student.setStuId(studentDTO.getStuId());
        student.setFullName(studentDTO.getFullName());
        student.setClassName(studentDTO.getClassName());
        student.setImageUrl(uploadImage.uploadToLocal(studentDTO.getImageFile()));

        //upload lên cloud
        String imageUrlCloud = uploadImage.uploadToCloud(studentDTO.getImageFile());
        model.addAttribute("student", student);
        model.addAttribute("imageUrlCloud", imageUrlCloud);
        return "view-student";
    }
}
