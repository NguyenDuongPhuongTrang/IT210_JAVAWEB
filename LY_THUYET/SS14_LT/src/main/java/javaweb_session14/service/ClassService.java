package javaweb_session14.service;

import javaweb_session14.model.entity.Classes;

import java.util.List;

public interface ClassService {
    List<Classes> getClasses();
    List<Classes> getAllOnlyClasses();
}
