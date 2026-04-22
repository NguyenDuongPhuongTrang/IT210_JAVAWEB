package lt.ss12_lt.repository;

import lt.ss12_lt.model.dto.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
