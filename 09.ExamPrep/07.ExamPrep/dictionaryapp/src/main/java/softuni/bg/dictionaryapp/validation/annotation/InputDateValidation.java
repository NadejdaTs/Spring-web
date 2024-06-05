package softuni.bg.dictionaryapp.validation.annotation;

import jakarta.validation.Payload;
import softuni.bg.dictionaryapp.validation.DateInThePastOrPresentValidator;

@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@jakarta.validation.Constraint(validatedBy = DateInThePastOrPresentValidator.class)
public @interface InputDateValidation {
    String message() default "The input date must be in the past or present!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
