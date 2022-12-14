package com.kodluyoruz.eticaret.Dto;
import com.kodluyoruz.eticaret.Annotations.CategoryAnnotations.CategoryRules;
import lombok.Data;

/**
 * @author sevgidemir
 */

@Data
public class CategoryRequestDto {

    @CategoryRules
    private String  categoryName;
}
