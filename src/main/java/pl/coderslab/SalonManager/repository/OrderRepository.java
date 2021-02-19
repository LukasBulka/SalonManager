package pl.coderslab.SalonManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.SalonManager.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
