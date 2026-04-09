package bt.ss05.bai3.service;

import bt.ss05.bai2.repository.DishRepository;
import bt.ss05.model.Dish;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private DishRepository dishRepository;

    public AdminService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    public Dish findById(String id) {
        return dishRepository.findAll()
                .stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void updateDish(Dish dish) {
        dishRepository.update(dish);
    }
}
