package kg.lalfo.lalafoservice.services;

import kg.lalfo.lalafoservice.entities.Category;
import kg.lalfo.lalafoservice.entities.Product;

import java.util.List;

public interface CategoryService {

    Category create(Category category);

    Category update(Long categoryId, String name, String description);

    void delete(Long categoryId);


    Category getById(Long id);
    List<Category> getAll();
}
