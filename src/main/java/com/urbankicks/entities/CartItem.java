package com.urbankicks.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class CartItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cart_item_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    private Product product;

    public Integer getCart_item_id() {
        return cart_item_id;
    }

    public void setCart_item_id(Integer cart_item_id) {
        this.cart_item_id = cart_item_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartItem [cart_item_id=" + cart_item_id + ", product=" + product + "]";
    }

    
}
