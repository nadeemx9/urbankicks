package com.urbankicks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbankicks.entities.Cart;
import com.urbankicks.entities.Product;
import com.urbankicks.repository.CartRepository;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public void addCart(Cart cart)
    {
        cartRepository.save(cart);
    }

    public List<Product> getCartProductsByuser(int user_id)
    {
        
        return null;
    }
}
