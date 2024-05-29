package softuni.bg.shopping.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import softuni.bg.shopping.validation.annotation.DateTimeInFuture;

import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class StringDateTimeInFutureValidator implements ConstraintValidator<DateTimeInFuture, String> {
    @Override
    public void initialize(DateTimeInFuture constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value != null && !value.isBlank()){
            LocalDateTime date = LocalDateTime.parse(value);
            return date.isAfter(LocalDateTime.now());
        }
        return false;
    }
}
