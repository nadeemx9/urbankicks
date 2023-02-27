package com.urbankicks.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductReview {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int review_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;
    private String email;
    private String reviewMsg;
    public int getReview_id() {
        return review_id;
    }
    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getReviewMsg() {
        return reviewMsg;
    }
    public void setReviewMsg(String reviewMsg) {
        this.reviewMsg = reviewMsg;
    }
    @Override
    public String toString() {
        return "ProductReview [review_id=" + review_id + ", user=" + user + ", name=" + name + ", email=" + email
                + ", reviewMsg=" + reviewMsg + "]";
    }
    
    
}
