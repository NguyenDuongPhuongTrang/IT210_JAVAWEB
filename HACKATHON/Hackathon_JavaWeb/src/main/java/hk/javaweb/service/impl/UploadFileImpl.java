package hk.javaweb.service.impl;

import jakarta.servlet.ServletContext;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import hk.javaweb.service.UploadFile;

import java.io.File;

@Service
public class UploadFileImpl implements UploadFile {

    private final ServletContext servletContext;
    private final String uploadDir = "uploads/avatars/";

    public UploadFileImpl(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Override
    public String uploadToLocal(MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            try {
                String rootPath = ResourceUtils.getFile("classpath:").getAbsolutePath();
                File uploadFolder = new File(rootPath, uploadDir);

                if (!uploadFolder.exists()) {
                    uploadFolder.mkdirs();
                }

                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                File destFile = new File(uploadFolder, fileName);

                file.transferTo(destFile);
                return "/uploads/avatars/" + fileName;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "/uploads/avatars/avatar-default.png";
    }
}
