package bt.bai4.service;

import bt.bai4.model.Order;
import bt.bai4.model.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    private final SessionFactory sessionFactory;

    public OrderService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void checkout(Long productId, int quantity) {
        Session session = sessionFactory.getCurrentSession();
        // Cập nhập khos
        int updated = session.createQuery("update Product p set p.stock = p.stock - :quantity where p.id = :id and p.stock > :quantity")
                .setParameter("id", productId)
                .setParameter("quantity", quantity)
                .executeUpdate();
        if (updated == 0) {
            throw new RuntimeException("Không đủ hàng tồn kho");
        }

        // Lưu order
        Order order = new Order();
        order.setStatus("PENDING");
        order.setExpiredAt(LocalDate.now());
        session.persist(order);

        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(productId);
        orderItem.setQuantity(quantity);
        orderItem.setOrder(order);
        session.persist(orderItem);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void confirm(Long orderId) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.createQuery("from Order where orderId = :id", Order.class)
                .setParameter("id", orderId)
                .uniqueResult();
        if (order == null || !order.getStatus().equals("PENDING")) {
            throw new RuntimeException("Order không tồn tại");
        }

        if (order.getExpiredAt().isBefore(LocalDate.now())) {
            throw new RuntimeException("Đơn hết hạn");
        }
        order.setStatus("CONFIRMED");
        session.merge(order);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void cancel(Long orderId) {
        Session session = sessionFactory.getCurrentSession();
        // Lấy danh sách item
        List<OrderItem> orderItems = session.createQuery("from OrderItem where id = :id", OrderItem.class)
                .setParameter("id", orderId)
                .getResultList();
        // Cộng lại vào kho
        for (OrderItem orderItem : orderItems) {
            session.createQuery("update Product p set p.stock = p.stock + :quantity where p.id = :id")
                    .setParameter("id", orderItem.getProductId())
                    .setParameter("quantity", orderItem.getQuantity())
                    .executeUpdate();
        }
        // Update trạng thái
        session.createQuery(
                        "UPDATE Order SET status = :status WHERE id = :id")
                .setParameter("status", "CANCELLED")
                .setParameter("id", orderId)
                .executeUpdate();
    }
}
