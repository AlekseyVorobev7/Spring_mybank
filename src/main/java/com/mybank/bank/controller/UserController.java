package com.mybank.bank.controller;

import com.mybank.bank.model.User;
import com.mybank.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public User register(@RequestBody Map<String,String> body) throws Exception{
        return userService.registerUser(body.get("name"), body.get("password"));
    }

    @PostMapping("/login")
    public User login(@RequestBody Map<String,String> body) throws Exception{
        return userService.logIn(body.get("name"), body.get("password"));
    }

    @GetMapping("/{id}")
    public User getUserByID(@PathVariable Long id) {
        return userService.getById(id);
    }
}
