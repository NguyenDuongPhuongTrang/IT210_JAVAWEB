package javaweb_session14.service.impl;

import javaweb_session14.model.entity.Classes;
import javaweb_session14.repository.ClassRepository;
import javaweb_session14.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<Classes> getClasses() {
        return classRepository.findAll();
    }

    @Override
    public List<Classes> getAllOnlyClasses() {
        return classRepository.findAllOnlyClasses();
    }
}
