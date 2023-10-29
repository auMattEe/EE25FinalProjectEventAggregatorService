package com.example.EE25FinalProjectEventAggregatorService.user;

import com.example.EE25FinalProjectEventAggregatorService.entity.User;
import com.example.EE25FinalProjectEventAggregatorService.user.dto.LoginRequest;
import com.example.EE25FinalProjectEventAggregatorService.user.dto.LoginResponse;
import com.example.EE25FinalProjectEventAggregatorService.user.dto.RegistrationRequest;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/login")
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
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        User newUser = new User();
        newUser.setUsername(registrationRequest.getUsername());
        newUser.setPassword(registrationRequest.getPassword());
        newUser.setFirstName(registrationRequest.getFirstName());
        newUser.setLastName(registrationRequest.getLastName());
        newUser.setEmail(registrationRequest.getEmail());

        boolean registrationResult = userService.registerUser(newUser);

        if (registrationResult) {
            return new ResponseEntity<>("Registration successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Registration failed", HttpStatus.BAD_REQUEST);
        }
    }
}
