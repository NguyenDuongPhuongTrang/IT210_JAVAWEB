package th.projectmember.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFile {
    public String uploadToLocal(MultipartFile file);
}
