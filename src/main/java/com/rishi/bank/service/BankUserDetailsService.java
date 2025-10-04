package com.rishi.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rishi.bank.model.User_Role;
import com.rishi.bank.respository.User_RoleRepository;

@Service
public class BankUserDetailsService implements UserDetailsService {

    @Autowired
    User_RoleRepository user_RoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User_Role user_Role=user_RoleRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return User.builder()
        .username(user_Role.getUsername())
        .password(user_Role.getPassword())
        .roles(user_Role.getRole())
        .build();
       // throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    }

    



}
