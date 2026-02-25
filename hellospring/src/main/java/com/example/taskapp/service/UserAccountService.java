package com.example.taskapp.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.taskapp.entity.UserAccount;
import com.example.taskapp.repository.UserAccountRepository;

@Service
public class UserAccountService implements UserDetailsService {

    private final UserAccountRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserAccountService(UserAccountRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }

    public void registerUser(String username, String password) {
        UserAccount newUser = new UserAccount();
        newUser.setUsername(username);
        
        newUser.setPassword(passwordEncoder.encode(password)); 
        
        repository.save(newUser);
    }
}