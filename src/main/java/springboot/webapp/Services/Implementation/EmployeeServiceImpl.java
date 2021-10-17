package springboot.webapp.Services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.webapp.Exceptions.ResourceNotFoundException;
import springboot.webapp.Models.Employee;
import springboot.webapp.Repositories.EmployeeRepository;
import springboot.webapp.Services.EmployeeService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            return employee.get();
        }
        else {
            throw new ResourceNotFoundException("Employee", "Id", id);
        }

        //Same with lamda expression
        //return employeeRepository.findById(id).orElseThrow(() ->
            // new ResourceNotFoundException("Employee", "Id", id))
    }
}
