package com.kodluyoruz.eticaret.Annotations.ItemAnnotations;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author sevgidemir
 */

@Target({  TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = {ItemPropertiesValidatorRules.class })
public @interface ItemPropertiesRules {

    String message() default "Price cannot be less than 0.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
