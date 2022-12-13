package app.prog.controller;

import app.prog.model.CategoryEntity;
import app.prog.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryEntity>getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/category/{id}")
    public CategoryEntity getCategoryById (@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }

}
