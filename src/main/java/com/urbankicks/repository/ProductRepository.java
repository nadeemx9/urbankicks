package com.urbankicks.repository;

import org.springframework.data.repository.CrudRepository;

import com.urbankicks.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    

}
