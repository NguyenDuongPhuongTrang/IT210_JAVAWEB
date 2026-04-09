package bt.ss05.bai5;

import bt.ss05.model.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private final List<Dish> dishes = new ArrayList<>();

    public OrderRepository() {
        dishes.add(new Dish("1", "Pizza", "A delicious pizza with ham and mushroom", 10.0));
        dishes.add(new Dish("2", "Burger", "A juicy burger with lettuce, tomato and cheese", 5.0));
        dishes.add(new Dish("3", "Fried Chicken", "A crispy piece of fried chicken", 7.0));
        dishes.add(new Dish("4", "Spaghetti", "A classic plate of spaghetti with meatballs", 8.0));
    }

    public List<Dish> findAll() {
        return dishes;
    }

    public Dish findById(String id) {
        return dishes.stream().filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
