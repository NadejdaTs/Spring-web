package softuni.bg.Gira.model.annotation;

import jakarta.validation.Payload;
import softuni.bg.Gira.vallidation.StringDateInFutureValidator;

@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@jakarta.validation.Constraint(validatedBy = StringDateInFutureValidator.class)
public @interface StringDateInFuture {
    String message() default "Date is not in future!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
