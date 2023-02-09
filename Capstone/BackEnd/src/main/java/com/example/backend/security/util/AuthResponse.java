package com.example.backend.security.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AuthResponse {
    private String token;
    private String role;
    private Long id;
    private String name;
}
