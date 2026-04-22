package th.projectmember.service.impl;

import jakarta.servlet.ServletContext;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import th.projectmember.service.UploadFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadFileImpl implements UploadFile {

    private final ServletContext servletContext;

    // Thêm dòng này để lấy đường dẫn thực tế của resources
    private final String uploadDir = "uploads/avatars/";   // thư mục con trong resources

    public UploadFileImpl(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Override
    public String uploadToLocal(MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            try {
                // Lấy đường dẫn tuyệt đối đến folder resources
                String rootPath = ResourceUtils.getFile("classpath:").getAbsolutePath();
                File uploadFolder = new File(rootPath, uploadDir);

                if (!uploadFolder.exists()) {
                    uploadFolder.mkdirs();
                }

                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                File destFile = new File(uploadFolder, fileName);

                file.transferTo(destFile);

                // Trả về đường dẫn để frontend gọi
                return "/uploads/avatars/" + fileName;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "/uploads/avatars/avatar-default.png";   // default
    }
}
