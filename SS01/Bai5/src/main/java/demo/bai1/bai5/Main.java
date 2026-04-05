package demo.bai1.bai5;

import demo.bai1.bai5.config.AppConfig;
import demo.bai1.bai5.model.SystemConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SystemConfig config = context.getBean(SystemConfig.class);
        config.displayInfo();
    }
}
