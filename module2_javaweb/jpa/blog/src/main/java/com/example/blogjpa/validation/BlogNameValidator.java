package com.example.blogjpa.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BlogNameValidator implements ConstraintValidator<BlogNameConstraint,String> {

    @Override
    public void initialize(BlogNameConstraint blogName) {
    }

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        return contactField != null && contactField.matches("[a-zA-Z]+")
                && (contactField.length() > 2) && (contactField.length() < 50);
    }
}
