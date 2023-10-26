package com.Synchrony.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private int status;
    private String message;
    private long timestamp;
    // Getters and setters
}

