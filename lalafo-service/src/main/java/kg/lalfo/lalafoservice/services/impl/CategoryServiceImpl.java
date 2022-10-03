package kg.lalfo.lalafoservice.services.impl;

import kg.lalfo.lalafoservice.entities.Category;
import kg.lalfo.lalafoservice.entities.Product;
import kg.lalfo.lalafoservice.repositories.CategoryRepository;
import kg.lalfo.lalafoservice.services.CategoryService;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long categoryId, String name, String description) {
        Category category = getById(categoryId);
        if (category != null) {
            category.setName(name);
            category.setDescription(description);
        }
        return categoryRepository.save( category);
    }



    @Override
    public void delete(Long categoryId) {
         categoryRepository.deleteById(categoryId);
    }



    @Override
    @Transactional(readOnly = true)
    public Category getById(@NonNull Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }


}
