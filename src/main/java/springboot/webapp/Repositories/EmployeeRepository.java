package springboot.webapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.webapp.Models.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
