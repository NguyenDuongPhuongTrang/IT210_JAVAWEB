package ss04.bai5.service;

import ss04.bai5.model.Order;

import java.util.List;

public interface IOrderService {
    public List<Order> findAll();

    public Order findById(int id);
}
