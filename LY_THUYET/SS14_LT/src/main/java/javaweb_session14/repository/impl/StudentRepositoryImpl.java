package javaweb_session14.repository.impl;

import javaweb_session14.model.entity.Student;
import javaweb_session14.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean insertStudent(Student student) {
        Session session = sessionFactory.openSession();
        try{
            session.doWork(conn -> conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ));
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }
}
