package kg.lalfo.lalafoservice.services;

import kg.lalfo.lalafoservice.entities.Category;
import kg.lalfo.lalafoservice.entities.Product;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Sort;
public interface ProductService {
    Product create(Product product);

    Product update(Long productId, String productName, String description, Category category, Long amount, String type,
                   Long userId);

    void delete(Long productId);

    List<Product> getAll();

    List<Product> getByName(String type, String name);
   Product getById(Long id);
}
