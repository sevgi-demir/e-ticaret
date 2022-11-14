package com.kodluyoruz.eticaret.Controller;
import com.kodluyoruz.eticaret.Dto.CategoryRequestDto;
import com.kodluyoruz.eticaret.Dto.CategoryResponseDto;
import com.kodluyoruz.eticaret.Dto.DeletedCategoryDto;
import com.kodluyoruz.eticaret.Service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


/**
 * @author sevgidemir
 */

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;


    @PostMapping("/add")
    public String add(@Valid @RequestBody CategoryRequestDto categoryRequestDto){
        return this.categoryService.add(categoryRequestDto);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody DeletedCategoryDto deletedCategoryDto) {
        return this.categoryService.delete(deletedCategoryDto);
    }

    @GetMapping("/getAll")
    public List<CategoryResponseDto> getAll() {
        return this.categoryService.getAll();
    }

}
