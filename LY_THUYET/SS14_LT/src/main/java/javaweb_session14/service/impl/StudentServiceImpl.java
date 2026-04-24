package javaweb_session14.service.impl;

import javaweb_session14.model.entity.Student;
import javaweb_session14.repository.StudentRepository;
import javaweb_session14.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public boolean insertStudent(Student student) {
        return studentRepository.insertStudent(student);
    }
}
