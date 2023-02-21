package com.urbankicks.entities;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Orders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
     Cart cart;

    private Double total;
    
    private String pymt_method = "COD";
    private LocalDateTime createdAt = LocalDateTime.now();


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getPymt_method() {
        return pymt_method;
    }

    public void setPymt_method(String pymt_method) {
        this.pymt_method = pymt_method;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Orders [order_id=" + order_id + ", user=" + user + ", cart=" + cart + ", total=" + total
                + ", pymt_method=" + pymt_method + ", createdAt=" + createdAt + "]";
    }

   

}
