package com.example.EE25FinalProjectEventAggregatorService.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse implements Serializable {
    private int id;
    private String username;
    private String password;

    public LoginResponse(String loginSuccessful, int id, String username) {
        this.id = id;
        this.username = username;
    }
}
