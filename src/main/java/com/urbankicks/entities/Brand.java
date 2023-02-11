package com.urbankicks.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Brand {
    @Id()
    private String brand_name;

    private int brand_id;
    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }


    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    @Override
    public String toString() {
        return "Brand [brand_name=" + brand_name + ", brand_id=" + brand_id + "]";
    }

    
}
