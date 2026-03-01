package com.thymeleafDemo.thymeleafDemo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME) // how long validation will be used - processing runtime
public @interface CourseCode {
    // defining default courseCode
    public String value() default "PL";

    // defining default error message
    public String message() default "must start with PL";

    // defining default groups
    public Class<?>[] groups() default {};

    // defining default payloads
    public Class<? extends Payload>[] payload()  default {};
}
