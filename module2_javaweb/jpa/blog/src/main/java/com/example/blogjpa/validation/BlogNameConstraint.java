package com.example.blogjpa.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BlogNameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface BlogNameConstraint {
    String message() default "Invalid blog name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
