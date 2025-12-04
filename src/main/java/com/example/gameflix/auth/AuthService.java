
package com.example.gameflix.auth;

import com.example.gameflix.user.User;
import com.example.gameflix.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public AuthService(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public AuthResponse register(AuthRequest req) {
        if (repo.existsByUsername(req.getUsername()))
            return new AuthResponse("Username already exists");

        User u = new User(req.getUsername(), encoder.encode(req.getPassword()));
        repo.save(u);
        return new AuthResponse("User registered successfully");
    }

    public AuthResponse login(AuthRequest req) {
        return repo.findByUsername(req.getUsername())
                .map(u -> encoder.matches(req.getPassword(), u.getPassword())
                        ? new AuthResponse("Login successful")
                        : new AuthResponse("Invalid username or password"))
                .orElse(new AuthResponse("Invalid username or password"));
    }
}
