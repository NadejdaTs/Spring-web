package softuni.bg.dictionaryapp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import softuni.bg.dictionaryapp.validation.annotation.InputDateValidation;

import java.time.LocalDate;

public class DateInThePastOrPresentValidator implements ConstraintValidator<InputDateValidation, String> {
    @Override
    public void initialize(InputDateValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value != null && !value.isBlank()){
            LocalDate date = LocalDate.parse(value);
            return date.isBefore(LocalDate.now());
        }
        return false;
    }
}
