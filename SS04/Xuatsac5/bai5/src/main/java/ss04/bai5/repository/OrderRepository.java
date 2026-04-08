package ss04.bai5.repository;

import org.springframework.stereotype.Repository;
import ss04.bai5.model.Order;

import java.util.ArrayList;
import java.util.List;

@Repository("bai5OrderRepository")
public class OrderRepository {
    private List<Order> orders = new ArrayList<>();

    public OrderRepository() {
        orders.add(new Order(1, "Burger", 5.0, 2, 10.0));
        orders.add(new Order(2, "Pizza", 8.0, 3, 24.0));
        orders.add(new Order(3, "Coffee", 3.0, 1, 3.0));
        orders.add(new Order(4, "Smoothie", 4.0, 1, 4.0));
        orders.add(new Order(5, "Sandwich", 6.0, 1, 6.0));
    }

    public List<Order> findAll() {
        return orders;
    }
}