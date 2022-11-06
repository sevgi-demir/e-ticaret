package com.kodluyoruz.eticaret.Concrete;
import com.kodluyoruz.eticaret.Dto.CategoryRequestDto;
import com.kodluyoruz.eticaret.Model.Category;
import com.kodluyoruz.eticaret.Repository.CategoryRepository;
import com.kodluyoruz.eticaret.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @author sevgidemir
 */

@RequiredArgsConstructor
@Service
public class CategoryManager implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    @Override
    public String add(CategoryRequestDto categoryRequestDto) {


        Category category=this.modelMapper.map(categoryRequestDto,Category.class);
        this.categoryRepository.save(category);
        return "Category added.";
    }
}
