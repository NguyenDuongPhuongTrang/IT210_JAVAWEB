package employee.employeemanagement.repository;

import employee.employeemanagement.model.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    Employee findById(String empId);
}
