package ra.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import ra.edu.model.entity.Product;
import ra.edu.repository.ProductRepository;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product insertProduct(Product product);
    List<Product> getProductsByName(String proName);
}
