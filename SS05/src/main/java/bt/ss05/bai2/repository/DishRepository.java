package bt.ss05.bai2.repository;

import bt.ss05.model.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository {
    private List<Dish> dishes = new ArrayList<>();

    public DishRepository() {
        Dish dish1 = new Dish("1", "Pizza", "Very tasty", 15.99);
        Dish dish2 = new Dish("2", "Burger", "Juicy beef and fresh lettuce", 12.99);
        Dish dish3 = new Dish("3", "Salad", "Healthy and fresh", 8.99);
        Dish dish4 = new Dish("4", "Sushi", "Fresh and delicious", 14.99);
        Dish dish5 = new Dish("5", "Tacos", "Spicy and flavorful", 11.99);
        dishes.add(dish1);
        dishes.add(dish2);
        dishes.add(dish3);
        dishes.add(dish4);
        dishes.add(dish5);
    }

    public List<Dish> findAll() {
        return dishes;
    }

    public void update(Dish dish) {
        dishes = dishes.stream().map(d -> d.getId().equals(dish.getId()) ? dish : d).toList();
    }
}
