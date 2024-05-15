package com.plannerapp.model.annotation;

import com.plannerapp.vallidation.StringDateInFutureValidator;

import javax.validation.Payload;
@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@javax.validation.Constraint(validatedBy = StringDateInFutureValidator.class)
public @interface StringDateInFuture {
    String message() default "Date is not in future!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
