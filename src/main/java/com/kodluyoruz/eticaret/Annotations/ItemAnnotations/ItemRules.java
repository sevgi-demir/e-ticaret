package com.kodluyoruz.eticaret.Annotations.ItemAnnotations;
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
@Constraint(validatedBy = { ItemValidatorRules.class })
public @interface ItemRules {

    String message() default "Same product available, add another product.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };



}
