package bt.bai3;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class HospitalComponent {
    @Value("${hospital.name}")
    private String hospitalName;
    @Value("${hospital.hotline}")
    private String hospitalHotline;

    public void printInfor() {
        System.out.println("Hospital name: " + hospitalName);
        System.out.println("Hospital hotline: " + hospitalHotline);
    }
}
