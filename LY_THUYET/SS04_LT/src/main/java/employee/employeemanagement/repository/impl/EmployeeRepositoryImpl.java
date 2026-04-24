package employee.employeemanagement.repository.impl;

import employee.employeemanagement.model.entity.Employee;
import employee.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private List<Employee> employees;

    public EmployeeRepositoryImpl(){
        employees = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            employees.add(new Employee("nv01","Nguyễn Văn Cường",true,sdf.parse("21/12/2000"),"Sóc Sơn - Hà Nội","Nhân sự","Giám đốc",50000000D));
            employees.add(new Employee("nv02","Trần Thanh Bình",true,sdf.parse("11/02/2001"),"Hoàn Kiếm - Hà Nội","Kế toán","Nhân viên",15000000D));
            employees.add(new Employee("nv03","Nguyễn Thuý Hằng",false,sdf.parse("07/10/1999"),"Phổ Yên - Thái Nguyên","Nhân sự","Nhân viên",12000000D));
            employees.add(new Employee("nv04","Lê Văn Nam",true,sdf.parse("14/12/2002"),"Ý Yên - Ninh Bình","Marketing","Nhân viên",8000000D));
            employees.add(new Employee("nv05","Nguyễn Gia Bách",true,sdf.parse("26/03/2000"),"Nam Trực - Ninh Bình","Lãnh đạo","Giám đốc",100000000D));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee findById(String empId) {
        return employees.stream().filter(employee -> employee.getEmpId().equals(empId)).findFirst().orElse(null);
    }
}
