package com.Synchrony.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationResponse {
    private Long userId;
    private String message;

    public UserRegistrationResponse(String user_registered_successfully) {
    }
}

