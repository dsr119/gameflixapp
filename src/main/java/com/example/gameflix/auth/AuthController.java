
package com.example.gameflix.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
        AuthResponse response = authService.register(request);
        if (response.getMessage().equals("User registered successfully"))
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        if (response.getMessage().equals("Username already exists"))
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        return ResponseEntity.badRequest().body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        AuthResponse response = authService.login(request);
        if (response.getMessage().equals("Login successful"))
            return ResponseEntity.ok(response);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}
