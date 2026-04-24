package bt.bai1.repository;

import bt.bai1.model.Order;
import bt.bai1.model.Wallet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PaymentRepository {
    private final SessionFactory sessionFactory;

    public PaymentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void processPayment(Long orderId, Long walletId, double totalAmount) {
        Session session = sessionFactory.getCurrentSession();
        try {
            // Bắt đầu transaction
            session.beginTransaction();

            // Cập nhật trạng thái đơn hàng
            Order order = session.find(Order.class, orderId);
            order.setStatus("PAID");
            session.merge(order);

            // Trừ tiền trong ví
            Wallet wallet = session.find(Wallet.class, walletId);
            wallet.setBalance(wallet.getBalance() - totalAmount);
            session.merge(wallet);

            // Commit
            session.getTransaction().commit();
        } catch (Exception e) {
            // Rollback nếu lỗi
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
