package com.kodluyoruz.eticaret.Annotations.ItemAnnotations;
import com.kodluyoruz.eticaret.Model.Item;
import com.kodluyoruz.eticaret.Repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author sevgidemir
 */

@RequiredArgsConstructor
public class ItemValidatorRules implements ConstraintValidator<ItemRules,String> {

private final ItemRepository itemRepository;

@Override
public boolean isValid(String value, ConstraintValidatorContext context) {

        Item item=this.itemRepository.findByItemName(value);
        if (item!=null){
             return false;
        }
        return true;
        }


}
