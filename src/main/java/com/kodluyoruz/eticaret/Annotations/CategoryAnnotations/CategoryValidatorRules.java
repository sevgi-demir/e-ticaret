package com.kodluyoruz.eticaret.Annotations.CategoryAnnotations;
import com.kodluyoruz.eticaret.Model.Category;
import com.kodluyoruz.eticaret.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author sevgidemir
 */

@RequiredArgsConstructor
public class CategoryValidatorRules implements ConstraintValidator<CategoryRules,String> {

    private final CategoryRepository categoryRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        Category category=this.categoryRepository.getByCategoryName(value);
        if (category!=null){
            return false;
        }
        return true;
    }
}
