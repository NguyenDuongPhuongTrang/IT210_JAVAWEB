package bt.bai3.service;

import bt.bai3.model.Order;
import bt.bai3.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private SessionFactory sessionFactory;

    @Transactional
    public void buy(Long productId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Product product = session.find(Product.class, productId);
            if (product.getStock() <= 0) {
                System.out.println("Hết hàng");
            }

            product.setStock(product.getStock() - 1);
            session.merge(product);

            Order order = new Order();
            order.setProductId(productId);
            session.merge(order);
            System.out.println("Mua thành công");
        } catch (OptimisticEntityLockException exception) {
            System.out.println("Hệ thống đang bận, vui lòng thử lại");
        }
    }
}
