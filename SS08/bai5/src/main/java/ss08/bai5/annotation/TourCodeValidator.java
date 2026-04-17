package ss08.bai5.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TourCodeValidator implements ConstraintValidator<ValidTourCode, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().isEmpty()) {
            return false;
        }
        return value.matches("^(VN_|INT_)\\d{5}$");
    }
}
