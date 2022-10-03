package kg.lalfo.lalafoservice.repositories;

import kg.lalfo.lalafoservice.entities.Product;
import kg.lalfo.lalafoservice.entities.RequestLogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestLogRepository extends JpaRepository<RequestLogs, Long> {
}
