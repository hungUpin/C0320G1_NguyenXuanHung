package com.example.login.validation;

import org.hibernate.annotations.Target;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PhoneNumberValidator implements
        ConstraintValidator<PhoneNumberConstrain, String> {

    @Override
    public void initialize(PhoneNumberConstrain phoneNumber) {
    }

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        return contactField != null && contactField.matches("^0[0-9]+$")
                && (contactField.length() > 5) && (contactField.length() < 16);
    }

}
