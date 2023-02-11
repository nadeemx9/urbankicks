package com.urbankicks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.urbankicks.repository.CategoryRepository;
import com.urbankicks.entities.Category;


import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> findAllCategories()
    {
        List<Category> categories =(List<Category>) categoryRepository.findAll();
        return categories;
    }
}
