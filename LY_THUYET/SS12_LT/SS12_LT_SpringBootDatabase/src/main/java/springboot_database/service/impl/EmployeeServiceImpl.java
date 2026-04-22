package springboot_database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot_database.model.entity.Employee;
import springboot_database.repository.EmployeeRepository;
import springboot_database.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
