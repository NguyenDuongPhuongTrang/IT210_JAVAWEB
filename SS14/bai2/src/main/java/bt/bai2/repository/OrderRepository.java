package bt.bai2.repository;

import bt.bai2.model.Order;
import bt.bai2.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OrderRepository {
    private final SessionFactory sessionFactory;

    public OrderRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void cancelOrder(Long orderId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            Order order = session.find(Order.class, orderId);
            if (order == null) {
                throw new RuntimeException("Đơn hàng không tồn tại");
            }

            // Huỷ đơn hàng
            order.setStatus("Cancelled");
            session.merge(order);

            // Hoàn kho
            Product product = session.find(Product.class, order.getProductId());
            product.setStock(product.getStock() + order.getQuantity());
            session.merge(product);

            // Commit
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            //Rollback nếu xảy ra lỗi
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
