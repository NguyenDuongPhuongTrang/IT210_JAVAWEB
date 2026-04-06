package btvn.ss02.xuatsac5.model;

import java.util.Date;

public class Employee {
    private String id;
    private String fullName;
    private String department;
    private double salary;
    private Date date;
    private String status;

    public Employee(String id, String fullName, String department, double salary, Date date, String status) {
        this.id = id;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.date = date;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}
