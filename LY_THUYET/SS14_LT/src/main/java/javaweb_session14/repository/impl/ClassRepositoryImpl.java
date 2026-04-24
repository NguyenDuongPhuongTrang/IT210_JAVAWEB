package javaweb_session14.repository.impl;

import javaweb_session14.model.entity.Classes;
import javaweb_session14.repository.ClassRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class ClassRepositoryImpl implements ClassRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Classes> findAll() {
        Session session = sessionFactory.openSession();
        try{
            return session.createQuery("from Classes order by className asc").list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Classes> findAllOnlyClasses() {
        Session session = sessionFactory.openSession();
        try{
            return session.createNativeQuery("select * from classes order by class_name asc", Classes.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}
