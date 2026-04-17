package ss08.bai5.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TourCodeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTourCode {
    String message() default "Mã Tour phải bắt đầu bằng VN_ hoặc INT_ và theo sau là 5 chữ số";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

