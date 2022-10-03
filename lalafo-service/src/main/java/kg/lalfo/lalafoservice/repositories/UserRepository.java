package kg.lalfo.lalafoservice.repositories;

import kg.lalfo.lalafoservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
