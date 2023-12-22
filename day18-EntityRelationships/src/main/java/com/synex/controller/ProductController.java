package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.Product;
import com.synex.service.ProductService;

@RestController
public class ProductController {
    
    @Autowired ProductService productService;
    
    @GetMapping("getProductById/{id}")
    public Product getProductById(@PathVariable long id) {
        return productService.findById(id);
    }
    
    @GetMapping("getAllProducts")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }
    
    @PostMapping("saveProduct")
    public Product saveProduct(@RequestBody Product product) {
        return productService.save(product);
    }
    
    @DeleteMapping("deleteProductById/{id}")
    public void deleteProductById(@PathVariable long id) {
        productService.deleteById(id);
    }

}
