package bt.bai4.repository;

import bt.bai4.model.Medicine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MedicineRepository {
    private final SessionFactory sessionFactory;

    public MedicineRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Medicine> findMedineBeforeExpiryDate() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Medicine where current_timestamp() > expiryDate", Medicine.class).list();
    }
}