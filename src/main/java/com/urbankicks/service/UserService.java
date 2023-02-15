package com.urbankicks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.urbankicks.entities.User;
import com.urbankicks.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(User user)
    {
        userRepository.save(user);
    }

    public User getUserById(int id)
    {
        User user = (User)userRepository.findById(id).get();
        return user;
    }

    public String encode(String password)
    {
        return bCryptPasswordEncoder.encode(password);
    }
  
    
}
