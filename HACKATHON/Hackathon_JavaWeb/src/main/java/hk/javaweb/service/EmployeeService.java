package hk.javaweb.service;

import hk.javaweb.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(String id);
    Employee save(Employee employee);
    void delete(String id);
    List<Employee> search(String keyword, String position);
}
