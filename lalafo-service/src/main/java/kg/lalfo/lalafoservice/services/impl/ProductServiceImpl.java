package kg.lalfo.lalafoservice.services.impl;

import kg.lalfo.lalafoservice.entities.Category;
import kg.lalfo.lalafoservice.entities.Product;
import kg.lalfo.lalafoservice.repositories.CategoryRepository;
import kg.lalfo.lalafoservice.repositories.ProductRepository;
import kg.lalfo.lalafoservice.services.ProductService;
import lombok.NonNull;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAll() {
        //  repository.findAllByCustomerExternalId()
        return repository.findAll();
    }


    @Override
    public List<Product> getByName(String type, String name) {
        return repository.findAllByCustomerExternalId(type, name);
    }


    @Override
    public Product create(Product product) {
        return repository.save(product);
    }

    @Override
    public Product update(Long productId, String productName, String description, Category category, Long amount, String type,
                          Long userId) {
        Product product = getById(productId);
        if (product != null) {
            product.setName(productName);
            product.setAmount(amount);
            product.setCategoryId(category);
            product.setDescription(description);
            product.setType(type);
            product.setUpdate(LocalDateTime.now());
        }
        return repository.save( product);
    }

    @Override
    public Product getById(@NonNull Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(@NonNull Long productId) {
        repository.deleteById(productId);
    }
}
