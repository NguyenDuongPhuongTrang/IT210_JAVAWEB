package lt.ss12_lt.repository.impl;

import lt.ss12_lt.model.dto.Product;
import lt.ss12_lt.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> products;

    public ProductRepositoryImpl(){
        products = List.of(
            new Product("P001", "Product 1", new Date(), 1000.0),
            new Product("P002", "Product 2", new Date(), 2000.0),
            new Product("P003", "Product 3", new Date(), 3000.0)
        );
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}
