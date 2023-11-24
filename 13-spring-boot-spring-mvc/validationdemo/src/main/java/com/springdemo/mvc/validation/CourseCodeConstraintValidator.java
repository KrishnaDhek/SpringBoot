package com.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// Validator class for the CourseCode annotation
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String > {

    // Variable to store the course prefix from the annotation
    private String coursePrefix;

    // Initialize the validator with the course prefix from the annotation
    @Override
    public void initialize(CourseCode theCourseCode) {
       coursePrefix =theCourseCode.value();
    }

    // Actual validation logic
    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

        // Check if the course code starts with the specified prefix
        boolean result ;

        if(theCode!=null){
            result =theCode.startsWith(coursePrefix);
        }
        else {
            result =true;
        }
        return result;
    }
}
