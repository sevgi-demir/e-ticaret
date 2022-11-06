package com.kodluyoruz.eticaret.Controller;
import com.kodluyoruz.eticaret.Dto.CategoryRequestDto;
import com.kodluyoruz.eticaret.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sevgidemir
 */

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/add")
    public String add(@RequestBody CategoryRequestDto categoryRequestDto){
        return this.categoryService.add(categoryRequestDto);
    }
}
