package ru.vtb.vtbbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vtb.vtbbackend.dto.RegisterReq;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder encoder;
    private final UserService userService;

    public boolean login(String email, String password) {
        if (userService.userExists(email).isEmpty()) {
            return false;
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        String encryptedPassword = userDetails.getPassword();
        return encoder.matches(password, encryptedPassword);
    }

    public boolean register(RegisterReq registerReq) {
        if (userService.userExists(registerReq.getEmail()).isPresent()) {
            return false;
        }

        String encodedPassword = encoder.encode(registerReq.getPassword());
        registerReq.setPassword(encodedPassword);
        userService.createUser(registerReq);
        return true;
    }
}
