package com.urbankicks.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Orders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    private List<Product> products;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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

    @Override
    public String toString() {
        return "Orders [order_id=" + order_id + ", user=" + user + ", products=" + products + ", total=" + total
                + ", pymt_method=" + pymt_method + ", createdAt=" + createdAt + "]";
    }

}
