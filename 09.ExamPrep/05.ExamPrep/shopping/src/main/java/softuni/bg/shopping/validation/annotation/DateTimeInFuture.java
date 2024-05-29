package softuni.bg.shopping.validation.annotation;

import jakarta.validation.Payload;
import softuni.bg.shopping.validation.StringDateTimeInFutureValidator;

@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@jakarta.validation.Constraint(validatedBy = StringDateTimeInFutureValidator.class)
public @interface DateTimeInFuture {
    String message() default "The date cannot be in the past!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
