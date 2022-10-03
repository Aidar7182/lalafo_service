package kg.lalfo.lalafoservice.repositories;

import kg.lalfo.lalafoservice.entities.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.type = ?1 and p.name = ?2")
    List<Product> findAllByCustomerExternalId(String type, String name);

    @Query(value = "select p from Product p where p.user = ?1")
    List<Product> findUser(Long id);

}
