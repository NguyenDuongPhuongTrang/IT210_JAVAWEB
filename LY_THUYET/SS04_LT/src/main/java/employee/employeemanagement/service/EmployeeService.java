package employee.employeemanagement.service;

import employee.employeemanagement.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee getEmployeeById(String empId);
}
