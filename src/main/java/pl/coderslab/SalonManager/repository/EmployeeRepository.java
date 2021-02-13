package pl.coderslab.SalonManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.SalonManager.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
