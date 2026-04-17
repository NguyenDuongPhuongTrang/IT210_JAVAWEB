package upload.updateload_image.config;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    private final Long MAX_FILE_SIZE = 20*1024*1024L;  // Tối đa file upload là 20MB
    private final Long MAX_REQUEST_SIZE = 100*1024*1024L; // Tối đa trong 1 lần upload là 100MB
    private final String TMP_LOCATION = ""; //Xử lý đường dẫn lưu trữ tuyệt đối, đặt "" là để tự xử lý lấy
    private final Integer FILE_SIZE_THRESHOLD = 0; // Đặt 0 là không giới hạn kích thước upload lên
    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement(TMP_LOCATION,MAX_FILE_SIZE,MAX_REQUEST_SIZE,FILE_SIZE_THRESHOLD));
    }
}
