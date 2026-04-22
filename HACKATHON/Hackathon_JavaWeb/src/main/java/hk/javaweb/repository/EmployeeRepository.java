package hk.javaweb.repository;

import hk.javaweb.model.entity.Employee;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepository {
    private final Map<String, Employee> data = new LinkedHashMap<>();
    private String currentId = "NV001";

    public List<Employee> findAll() {
        return new ArrayList<>(data.values());
    }

    public Employee findById(String id) {
        return data.get(id);
    }

    public Employee save(Employee employee) {
        if (employee.getId() == null || employee.getId().trim().isEmpty()) {
            String newId = getNextId();
            employee.setId(newId);
        }
        data.put(employee.getId(), employee);
        return employee;
    }

    public void delete(String id) {
        data.remove(id);
    }

    private String getNextId() {
        String newId = currentId;
        int number = Integer.parseInt(currentId.substring(2)) + 1;
        currentId = String.format("NV%03d", number);
        return newId;
    }
}