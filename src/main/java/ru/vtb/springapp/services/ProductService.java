package ru.vtb.springapp.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vtb.springapp.domain.Product;
import ru.vtb.springapp.repos.ProductRepo;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductService {
    private ProductRepo productRepo;

    public void save(Product product) {
        productRepo.save(product);
    }

    public Product getById(Long id) {
        return productRepo.getById(id);
    }

    public List<Product> getAll() {
        return productRepo.getAll();
    }
}
