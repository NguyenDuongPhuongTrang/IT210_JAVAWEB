package hk.javaweb.service.impl;

import hk.javaweb.model.entity.Employee;
import hk.javaweb.repository.EmployeeRepository;
import hk.javaweb.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(String id) {
        employeeRepository.delete(id);
    }

    @Override
    public List<Employee> search(String keyword, String position) {
        return employeeRepository.findAll().stream()
                .filter(e -> keyword == null || keyword.trim().isEmpty() ||
                        e.getFullName().toLowerCase().contains(keyword.toLowerCase().trim()))
                .filter(e -> position == null || position.trim().isEmpty() ||
                        e.getPosition().equals(position))
                .toList();
    }
}
