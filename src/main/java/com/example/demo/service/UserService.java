package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public User blockUser(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setBlocked(true);
            return userRepository.save(user);
        }
        return null;
    }

       public User resetPassword(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String newPassword = UUID.randomUUID().toString();  // Generar una nueva contraseña aleatoria
            user.setPassword(newPassword);  // Suponiendo que tienes un campo de contraseña en tu modelo User
            return userRepository.save(user);
        }
        return null;
    }
}
