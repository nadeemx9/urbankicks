package com.urbankicks.repository;

import org.springframework.data.repository.CrudRepository;

import com.urbankicks.entities.Brand;

public interface BrandRepository extends CrudRepository<Brand, String> {
    
}
