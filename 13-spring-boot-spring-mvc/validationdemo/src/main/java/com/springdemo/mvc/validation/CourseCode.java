package com.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define a custom validation annotation CourseCode
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // Define default course code ("SPR" by default)
    public String value() default "SPR";

    // Define default error message ("must start with SPR" by default)
    public String message() default "must start with SPR";

    // Define default validation groups
    public Class<?>[] groups() default {};

    //define default payloads
    public Class<? extends Payload>[] payload() default{};

}
