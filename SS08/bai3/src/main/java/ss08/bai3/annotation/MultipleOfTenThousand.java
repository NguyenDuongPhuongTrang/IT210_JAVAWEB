package ss08.bai3.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MultipleOfTenThousandValidator.class)
@Documented
public @interface MultipleOfTenThousand {

    String message() default "Số tiền rút phải là bội số của 10.000 VNĐ và >= 50.000 VNĐ. " +
            "Ví dụ hợp lệ: 50.000, 60.000, 150.000";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    long minValue() default 50_000;

    long multipleOf() default 10_000;
}