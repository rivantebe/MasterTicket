package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin/users")
public class AdminController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PatchMapping("/{id}/block")
    public User blockUser(@PathVariable String id) {
        return userService.blockUser(id);
    }

    @PostMapping("/{id}/reset-password")
    public User resetPassword(@PathVariable String id) {
        return userService.resetPassword(id);
    }
}
