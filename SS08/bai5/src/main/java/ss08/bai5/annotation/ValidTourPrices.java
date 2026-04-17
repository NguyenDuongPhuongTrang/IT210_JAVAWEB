package ss08.bai5.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TourPricesValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTourPrices {
    String message() default "Giá vé trẻ em không được lớn hơn giá vé người lớn";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
