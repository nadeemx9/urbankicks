package com.urbankicks.repository;

import org.springframework.data.repository.CrudRepository;

import com.urbankicks.entities.User;


public interface UserRepository extends CrudRepository<User, Integer>  {
 
    public User findByUsername(String username);
}
