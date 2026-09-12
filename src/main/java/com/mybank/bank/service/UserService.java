package com.mybank.bank.service;

import org.springframework.stereotype.Service;
import com.mybank.bank.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<User>();

    public User registerUser(Long id, String name, String password) {
        User user = new User(id, name, password, LocalDateTime.now());
        users.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return users;
    }
}
