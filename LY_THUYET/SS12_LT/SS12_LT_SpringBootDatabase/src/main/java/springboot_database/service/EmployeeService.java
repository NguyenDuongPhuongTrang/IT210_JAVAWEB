package springboot_database.service;

import springboot_database.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee insertEmployee(Employee employee);
}
