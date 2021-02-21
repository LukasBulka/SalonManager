package pl.coderslab.SalonManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.SalonManager.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
