package com.example.EE25FinalProjectEventAggregatorService.user;

import com.example.EE25FinalProjectEventAggregatorService.entity.Event;
import com.example.EE25FinalProjectEventAggregatorService.entity.User;
import com.example.EE25FinalProjectEventAggregatorService.user.dto.LoginRequest;
import com.example.EE25FinalProjectEventAggregatorService.user.dto.LoginResponse;
import com.example.EE25FinalProjectEventAggregatorService.user.dto.RegistrationRequest;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/events")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        User user = userService.login(loginRequest.getUsername(), loginRequest.getPassword());

        if (user != null) {
            LoginResponse loginResponse = new LoginResponse("Login successful", user.getId(), user.getUsername());
            return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        User newUser = new User();
        newUser.setUsername(registrationRequest.getUsername());
        newUser.setPassword(registrationRequest.getPassword());
        newUser.setFirstName(registrationRequest.getFirstName());
        newUser.setLastName(registrationRequest.getLastName());
        newUser.setEmail(registrationRequest.getEmail());

        boolean registrationResult = userService.registerUser(newUser);

        Map<String, String> response = new HashMap<>();
        if (registrationResult) {
            response.put("message", "Registration successful");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Registration failed");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/userupdate")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/userdelete")
    public ResponseEntity<?> deleteEvent(@RequestParam Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}