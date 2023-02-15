package com.urbankicks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.urbankicks.entities.CartItem;

@Service
public class CartItemService {

    public void addToCart(CartItem cartItem)
    {
        System.out.println(cartItem);
    }

    public List<CartItem> getCartItemsByUser(int id)
    {
        return null;
    }
}
