package ra.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.model.entity.Product;
import ra.edu.repository.ProductRepository;
import ra.edu.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.insertProduct(product);
    }

    @Override
    public List<Product> getProductsByName(String proName) {
        if(proName == null || proName.length()==0){
            proName = "%";
        }else{
            proName = "%"+proName+"%";
        }
        return productRepository.findByProductName(proName);
    }
}
