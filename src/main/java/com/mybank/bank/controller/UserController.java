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
    public User register(@RequestBody Map<String,String> body){
        return userService.registerUser(Long.parseLong(body.get("id")), body.get("name"), body.get("password"));

    }
}
