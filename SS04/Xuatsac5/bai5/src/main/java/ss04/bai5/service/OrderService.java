package ss04.bai5.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ss04.bai5.model.Order;
import ss04.bai5.repository.OrderRepository;

import java.util.List;

@Service("bai5OrderService")
public class OrderService implements IOrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findAll()
                .stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
