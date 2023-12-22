package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Product;
import com.synex.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired ProductRepository productRepository;
    
    public Product findById(long id) {
        return productRepository.findById(id).orElse(null);
    }
    
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    
    public Product save(Product product) {
        return productRepository.save(product);
    }
    
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
}
