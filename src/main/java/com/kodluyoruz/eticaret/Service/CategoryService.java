package com.kodluyoruz.eticaret.Service;
import com.kodluyoruz.eticaret.Dto.CategoryRequestDto;
import com.kodluyoruz.eticaret.Dto.CategoryResponseDto;
import com.kodluyoruz.eticaret.Dto.DeletedCategoryDto;
import java.util.List;

/**
 * @author sevgidemir
 */
public interface CategoryService {

    String add(CategoryRequestDto categoryRequestDto);

    String delete(DeletedCategoryDto deletedCategoryDto);

    List<CategoryResponseDto> getAll();
}
