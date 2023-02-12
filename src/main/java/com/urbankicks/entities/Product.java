package com.urbankicks.entities;


import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int prod_id;

    private String prod_name;

    private String description;
    
    @ManyToOne
    @JoinColumn(name = "category_name")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_name")
    private Brand brand;

    private Integer size;
    private String gender;
    private Integer quantity;
    private Double price;
    
    @Lob()
    @Column(columnDefinition="LONGBLOB")
    private byte[] img1;

    @Lob
    @Column(columnDefinition="LONGBLOB")
    private byte[] img2;

    @Lob
    @Column(columnDefinition="LONGBLOB")
    private byte[] img3;

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getImg1() {
        return img1;
    }

    public void setImg1(byte[] img1) {
        this.img1 = img1;
    }

    public byte[] getImg2() {
        return img2;
    }

    public void setImg2(byte[] img2) {
        this.img2 = img2;
    }

    public byte[] getImg3() {
        return img3;
    }

    public void setImg3(byte[] img3) {
        this.img3 = img3;
    }
  
    public String getBrandName()
    {
        return brand.getBrand_name();
    }
    

    @Override
    public String toString() {
        return "Product [prod_id=" + prod_id + ", prod_name=" + prod_name + ", description=" + description
                + ", category=" + category + ", brand=" + brand + ", size=" + size + ", gender=" + gender
                + ", quantity=" + quantity + ", price=" + price + ", img1=" + Arrays.toString(img1) + ", img2="
                + Arrays.toString(img2) + ", img3=" + Arrays.toString(img3) + "]";
    }


        
    
}
