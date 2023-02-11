package com.urbankicks.repository;

import org.springframework.data.repository.CrudRepository;

import com.urbankicks.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, String> {
    
}
