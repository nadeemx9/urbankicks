package com.urbankicks.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.urbankicks.entities.User;
import com.urbankicks.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user1 = userRepository.findByUsername(username);

        if (user1 == null) {
            throw new UsernameNotFoundException("Username not found!");
        } 

            UserDetailsImpl userdetails = new UserDetailsImpl();
            userdetails.setUser(user1);
            return userdetails;
        

    }

}
