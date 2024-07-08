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

    @PatchMapping("/{id}/block")
    public User blockUser(@PathVariable String id) {
        return userService.blockUser(id);
    }
}
