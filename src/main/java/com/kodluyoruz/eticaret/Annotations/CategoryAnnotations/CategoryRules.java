package com.kodluyoruz.eticaret.Annotations.CategoryAnnotations;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author sevgidemir
 */

@Target({  FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = {CategoryValidatorRules.class })
public @interface CategoryRules {

    String message() default "Same category available, add another category.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}