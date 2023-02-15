package com.urbankicks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbankicks.entities.CartItem;
import com.urbankicks.repository.CartItemRepository;

@Service
public class CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;
    public void addToCart(CartItem cartItem)
    {
        cartItemRepository.save(cartItem);
    }

    public List<CartItem> getCartItemsByUser(int id)
    {
        List<CartItem> cartItems =(List<CartItem>) cartItemRepository.getCartItemsByUser(id);
        return cartItems;
    }

    public CartItem findById(int id)
    {
        CartItem cartItem = cartItemRepository.findById(id);
        return cartItem;
    }
    public void removeFromCart(CartItem cartItem)
    {
        cartItemRepository.delete(cartItem);
    }

    
}
