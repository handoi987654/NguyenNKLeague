package com.Desert.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = DifferentClubValidator.class)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DifferentClub {

    String message() default "Please choose 2 different teams!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
