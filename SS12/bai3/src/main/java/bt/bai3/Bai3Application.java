package bt.bai3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bai3Application {

    private HospitalComponent hospitalComponent;

    @Autowired
    public void setHospitalComponent(HospitalComponent hospitalComponent) {
        this.hospitalComponent = hospitalComponent;
        hospitalComponent.printInfor();
    }

    public static void main(String[] args) {
        SpringApplication.run(Bai3Application.class, args);
    }
}
