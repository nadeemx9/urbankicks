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

    public Cart addCart(Cart cart)
    {
        return cartRepository.save(cart);
    }

    public List<Product> getCartProductsByuser(int user_id)
    {
        Cart cart = getCartByUser(user_id);
        
        List<Product> products = cart.getProducts();
        return products;
    }

    public Cart getCartByUser(int user_id)
    {
        Cart cart = (Cart)cartRepository.getCartByUser(user_id);

        return cart;
    }

    
}
