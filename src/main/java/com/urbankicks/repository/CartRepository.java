package com.urbankicks.repository;

import org.springframework.data.repository.CrudRepository;

import com.urbankicks.entities.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {
    
}
