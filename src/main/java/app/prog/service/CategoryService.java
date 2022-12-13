package app.prog.service;

import app.prog.model.CategoryEntity;
import app.prog.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryEntity>getCategories(){
        return categoryRepository.findAll();
    }

    public CategoryEntity getCategoryById(int id){
        return categoryRepository.findById(id).orElseThrow(()->new RuntimeException("BookEntity." + id +" not found"));
    }

}
