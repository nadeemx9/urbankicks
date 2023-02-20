package com.urbankicks.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cart_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "user_id")
    private User user_id;

    @OneToMany
    private List<Product> products;

    
    public int getCart_id() {
        return cart_id;
    }


    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Cart [cart_id=" + cart_id + ", user_id=" + user_id + ", products=" + products + "]";
    }

    
}
