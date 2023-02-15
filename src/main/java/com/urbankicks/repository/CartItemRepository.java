package com.urbankicks.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.urbankicks.entities.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem, String> {

    public List<CartItem> getCartItemsByUser(int id);
    
    
}
