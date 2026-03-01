package com.thymeleafDemo.thymeleafDemo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theGivenCode, ConstraintValidatorContext theContext) {
        boolean result = true;

        if  (theGivenCode != null) { result = theGivenCode.startsWith(coursePrefix); }

        return result;

    }

}
