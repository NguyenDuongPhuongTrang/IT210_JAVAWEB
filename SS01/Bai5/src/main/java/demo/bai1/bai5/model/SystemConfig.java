package demo.bai1.bai5.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemConfig {
    @Value("Phtrang")
    private String branchName;

    @Value("8:00 - 23:00")
    private String openingHour;

    public void displayInfo() {
        System.out.println("Tên cửa hàng: " + branchName);
        System.out.println("Giờ mở cửa: " + openingHour);
    }
}
