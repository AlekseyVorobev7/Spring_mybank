package com.mybank.bank.service;

import com.mybank.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import com.mybank.bank.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User registerUser(String name, String password) throws Exception {
        if (userRepository.existsByName(name)) {
            throw new Exception("Такой пользователь уже существует!");
        }
        User user = userRepository.save(new User(name,password));
        return user;

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getById(Long id){
        return userRepository.findById(id).orElseThrow(() ->new RuntimeException("Пользователя нет"));
    }
}
