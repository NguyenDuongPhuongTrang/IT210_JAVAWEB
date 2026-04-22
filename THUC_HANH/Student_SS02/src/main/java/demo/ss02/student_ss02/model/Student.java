package demo.ss02.student_ss02.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    private String studentId;
    private String fullName;
    boolean isMale;
    private LocalDate dateOfBirth;
    private String hometown;
    private String className;

    public Student(){}

    public Student(String studentId, String fullName, boolean isMale, LocalDate dateOfBirth, String hometown, String className) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.isMale = isMale;
        this.dateOfBirth = dateOfBirth;
        this.hometown = hometown;
        this.className = className;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFormattedDateOfBirth() {
        return dateOfBirth.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
