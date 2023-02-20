package com.urbankicks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbankicks.entities.Product;
import com.urbankicks.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts()
    {
        List<Product> products =(List<Product>) productRepository.findAll();
        return products;
    }

    public Product findById(int id)
    {
        return (Product)productRepository.findById(id).get();
    }

    public void addProduct(Product product)
    {   
        productRepository.save(product);
    }
    
    
    public Double getTotal(List<Product> products) {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }
}
