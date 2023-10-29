package com.example.EE25FinalProjectEventAggregatorService.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse implements Serializable {
    private String username;
    private String password;

    public LoginResponse(String loginSuccessful, Integer id, String username) {
    }
}
