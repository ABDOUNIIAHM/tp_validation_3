package com.example.tp_validation_3.service;

import com.example.tp_validation_3.entity.User;
import com.example.tp_validation_3.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserDetails userDetails = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email"+ email+" not found !"));
        return userDetails;

    }
}
