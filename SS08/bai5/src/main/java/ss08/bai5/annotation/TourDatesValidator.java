package ss08.bai5.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ss08.bai5.model.dto.TourDto;

public class TourDatesValidator implements ConstraintValidator<ValidTourDates, TourDto> {
    @Override
    public boolean isValid(TourDto tour, ConstraintValidatorContext context) {
        if (tour == null || tour.getStartDate() == null || tour.getEndDate() == null) {
            return true;
        }

        boolean isValid = tour.getEndDate().isAfter(tour.getStartDate());

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("endDate").addConstraintViolation();
        }

        return isValid;
    }
}

