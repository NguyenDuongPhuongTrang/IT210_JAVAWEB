package ra.edu.repository;

import ra.edu.model.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product insertProduct(Product product);
    List<Product> findByProductName(String proName);
}
