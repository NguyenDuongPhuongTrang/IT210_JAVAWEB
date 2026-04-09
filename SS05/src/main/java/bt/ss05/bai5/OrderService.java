package bt.ss05.bai5;

import bt.ss05.model.Dish;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Dish> getAllDishes() {
        return repository.findAll();
    }

    public Dish getDishById(String id) {
        Dish dish = repository.findById(id);
        if (dish == null) {
            throw new RuntimeException("Dish with ID " + id + " not found");
        }
        return dish;
    }

    public double calculateTotal(double price, int quantity) {
        return price * quantity;
    }
}
