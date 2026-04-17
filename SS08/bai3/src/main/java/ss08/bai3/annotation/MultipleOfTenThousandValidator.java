package ss08.bai3.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MultipleOfTenThousandValidator implements ConstraintValidator<MultipleOfTenThousand, Long> {

    private long minValue;
    private long multipleOf;

    @Override
    public void initialize(MultipleOfTenThousand constraintAnnotation) {
        this.minValue = constraintAnnotation.minValue();
        this.multipleOf = constraintAnnotation.multipleOf();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        if (value < minValue) {
            addConstraintViolation(context,
                    String.format("Số tiền rút tối thiểu là %,d VNĐ", minValue));
            return false;
        }

        if (value % multipleOf != 0) {
            addConstraintViolation(context,
                    String.format("Số tiền rút phải là bội số của %,d VNĐ. Ví dụ: %,d, %,d, %,d",
                            multipleOf, minValue, minValue + multipleOf, minValue + 2 * multipleOf));
            return false;
        }

        return true;
    }

    private void addConstraintViolation(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
    }
}
