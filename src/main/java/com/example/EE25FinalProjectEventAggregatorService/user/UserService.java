package com.example.EE25FinalProjectEventAggregatorService.user;

import com.example.EE25FinalProjectEventAggregatorService.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepo userRepo;

    public User login(String username, String password) {
        return userRepo.findUserByUsernameAndPassword(username, password);
    }

    public boolean registerUser(User newUser) {
        if (isUsernameOrEmailAlreadyExists(newUser.getUsername(), newUser.getEmail())) {
            return false;
        }

        try {
            userRepo.save(newUser);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isUsernameOrEmailAlreadyExists(String username, String email) {
        return userRepo.existsByUsernameOrEmail(username, email);
    }
}