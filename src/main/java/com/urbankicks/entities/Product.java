package com.urbankicks.entities;



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

    private Integer prod_id;

    private String prod_name;

    
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "category_name")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_name")
    private Brand brand;

    private String size;
    private String gender;
    private Integer quantity;
    private Double price;
    
    @Lob()
    @Column(columnDefinition="LONGBLOB")
    private String img1;

    @Lob
    @Column(columnDefinition="LONGBLOB")
    private String img2;

    @Lob
    @Column(columnDefinition="LONGBLOB")
    private String img3;

  
    public String getBrandName()
    {
        return brand.getBrand_name();
    }

    public String getCategoryName()
    {
        return category.getCategory_name();
    }


    public Integer getProd_id() {
        return prod_id;
    }


    public void setProd_id(Integer prod_id) {
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


    public String getImg1() {
        return img1;
    }


    public void setImg1(String img1) {
        this.img1 = img1;
    }


    public String getImg2() {
        return img2;
    }


    public void setImg2(String img2) {
        this.img2 = img2;
    }


    public String getImg3() {
        return img3;
    }


    public void setImg3(String img3) {
        this.img3 = img3;
    }


    @Override
    public String toString() {
        return "Product [prod_id=" + prod_id + ", prod_name=" + prod_name + ", description=" + description
                + ", category=" + category + ", brand=" + brand + ", size=" + size + ", gender=" + gender
                + ", quantity=" + quantity + ", price=" + price + ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3
                + "]";
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
            
}
