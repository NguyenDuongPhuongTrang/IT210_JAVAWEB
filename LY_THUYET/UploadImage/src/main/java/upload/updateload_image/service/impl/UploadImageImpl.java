package upload.updateload_image.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import jakarta.servlet.ServletContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import upload.updateload_image.service.UploadImage;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class UploadImageImpl implements UploadImage {
    private ServletContext servletContext;
    private Cloudinary cloudinary;

    public UploadImageImpl(ServletContext servletContext,  Cloudinary cloudinary) {
        this.servletContext = servletContext;
        this.cloudinary = cloudinary;
    }

    private String destPath = "";

    @Override
    public String uploadToLocal(MultipartFile file) {
        //xử lý upload ảnh:
        if(file!=null && !file.isEmpty()){
            String realPath = servletContext.getRealPath("/resources/images");

            File f = new File(realPath);
            if (!f.exists()) {
                f.mkdirs(); //Nếu không tồn tại thì tạo ra thư mục images nằm trong resources
            }

            destPath = f.getAbsolutePath()+"/"+file.getOriginalFilename(); // Lấy về đường dẫn gốc của ổ đĩa

            try {
                file.transferTo(new File(destPath));
                return file.getOriginalFilename();
            } catch (IOException e) {
                System.out.println("Upload failed! "+e.getMessage());
            }
        }
        return "";
    }

    @Override
    public String uploadToCloud(MultipartFile file) {
        if(file!=null && !file.isEmpty()){
            try {
                Map upload = cloudinary.uploader().upload(destPath, ObjectUtils.emptyMap());
                return upload.get("secure_url").toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "";
    }
}
