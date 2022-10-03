package kg.lalfo.lalafoservice.repositories;

import kg.lalfo.lalafoservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
