package com.born2code.spring.web.validation;

import org.apache.commons.validator.routines.EmailValidator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidation implements ConstraintValidator<ValidEmail, String> {

    private int min;
    @Override
    public void initialize(ValidEmail constraintAnnotation){
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context){
        if(email.length() < min || !EmailValidator.getInstance(false).isValid(email)){
            return false;
        } else {
            return true;
        }
    }

}
