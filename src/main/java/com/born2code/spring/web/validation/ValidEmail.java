package com.born2code.spring.web.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {com.born2code.spring.web.validation.EmailValidation.class}
)
public @interface ValidEmail {
    String message() default "That does not seem to be a valid email address";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int min() default 5;
}
