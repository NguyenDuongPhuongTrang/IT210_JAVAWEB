package javaweb_session14.repository;

import javaweb_session14.model.entity.Classes;

import java.util.List;

public interface ClassRepository {
    List<Classes> findAll();
    List<Classes> findAllOnlyClasses();
}
