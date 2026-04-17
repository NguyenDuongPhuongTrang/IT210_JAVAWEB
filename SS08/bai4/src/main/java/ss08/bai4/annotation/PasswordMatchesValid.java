package ss08.bai4.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ss08.bai4.model.User;

public class PasswordMatchesValid implements ConstraintValidator<PasswordMatches, User> {
    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {
        return value.getPassword().equals(value.getComfirmPassword());
    }
}
