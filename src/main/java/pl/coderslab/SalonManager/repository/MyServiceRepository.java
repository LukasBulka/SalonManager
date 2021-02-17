package pl.coderslab.SalonManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.SalonManager.model.MyService;

@Repository
public interface MyServiceRepository extends JpaRepository<MyService, Long> {


}
