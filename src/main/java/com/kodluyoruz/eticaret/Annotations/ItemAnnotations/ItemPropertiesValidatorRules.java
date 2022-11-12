package com.kodluyoruz.eticaret.Annotations.ItemAnnotations;
import com.kodluyoruz.eticaret.Dto.ItemRequestDto;
import lombok.RequiredArgsConstructor;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author sevgidemir
 */

@RequiredArgsConstructor
public class ItemPropertiesValidatorRules implements ConstraintValidator<ItemPropertiesRules, ItemRequestDto> {

    @Override
    public boolean isValid(ItemRequestDto value, ConstraintValidatorContext context){
        if (value.getItemPrice()<0 ){
            return false;
        }
        return true;
    }
}
