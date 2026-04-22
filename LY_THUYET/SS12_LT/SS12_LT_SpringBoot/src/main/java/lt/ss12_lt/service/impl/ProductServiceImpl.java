package lt.ss12_lt.service.impl;

import lt.ss12_lt.model.dto.Product;
import lt.ss12_lt.repository.ProductRepository;
import lt.ss12_lt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getProduct() {
        return productRepository.findAll();
    }
}
