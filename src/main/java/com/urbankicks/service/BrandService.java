package com.urbankicks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbankicks.entities.Brand;
import com.urbankicks.repository.BrandRepository;

@Service
public class BrandService {
    
    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> findAllBrands()
    {
        List<Brand> brands =(List<Brand>) brandRepository.findAll();
        return brands;
    }
  
}
