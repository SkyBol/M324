package ch.group3.bandmanagement.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidDissolutionDateValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDissolutionDate {

    String message() default "dissolution date must be before the founding date!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
