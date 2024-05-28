package softuni.bg.Gira.vallidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import softuni.bg.Gira.model.annotation.StringDateInFuture;

import java.time.LocalDate;

public class StringDateInFutureValidator implements ConstraintValidator<StringDateInFuture, String> {
    @Override
    public void initialize(StringDateInFuture constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value != null && !value.isBlank()){
            LocalDate date = LocalDate.parse(value);
            return date.isAfter(LocalDate.now());
        }
        return false;
    }
}
