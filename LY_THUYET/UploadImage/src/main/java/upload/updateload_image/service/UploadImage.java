package upload.updateload_image.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadImage {
    public String uploadToLocal(MultipartFile file);

    public String uploadToCloud(MultipartFile file);
}
