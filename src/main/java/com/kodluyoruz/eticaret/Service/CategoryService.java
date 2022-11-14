package com.kodluyoruz.eticaret.Service;

import com.kodluyoruz.eticaret.Dto.CategoryRequestDto;
import com.kodluyoruz.eticaret.Dto.CategoryResponseDto;
import com.kodluyoruz.eticaret.Dto.DeletedCategoryDto;
import com.kodluyoruz.eticaret.Model.Category;
import com.kodluyoruz.eticaret.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sevgidemir
 */

@RequiredArgsConstructor
@Service
public class CategoryService implements ICategoryService{

    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    @Override
    public String add(CategoryRequestDto categoryRequestDto) {


        Category category=this.modelMapper.map(categoryRequestDto,Category.class);
        this.categoryRepository.save(category);
        return "Category added.";
    }

    @Override
    public String delete(DeletedCategoryDto deletedCategoryDto) {
        Category category=this.categoryRepository.findByCategoryId(deletedCategoryDto.getId());
        if(category==null){
            return "Category not found.";
        }
        this.categoryRepository.delete(category);
        return "Category deleted.";
    }

    @Override
    public List<CategoryResponseDto> getAll() {

        List<Category> categories=this.categoryRepository.findAll();
        List<CategoryResponseDto> categoryResponseDtoList=new ArrayList<>();
        for (Category category : categories) {
            CategoryResponseDto categoryResponseDto=this.modelMapper.map(category,CategoryResponseDto.class);
            categoryResponseDtoList.add(categoryResponseDto);
        }

        return categoryResponseDtoList;
    }

}
