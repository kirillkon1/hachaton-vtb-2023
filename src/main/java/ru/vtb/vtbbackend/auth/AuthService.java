//package ru.vtb.vtbbackend.service;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import ru.vtb.vtbbackend.auth.user.UserService;
//
//@Service
//@RequiredArgsConstructor
//public class AuthService {
//    private final PasswordEncoder encoder;
//    private final UserService userService;
//
//    public boolean login(String email, String password) {
//
//        var user = userService.getUser()
//
//
//        return encoder.matches(password, encryptedPassword);
//    }
//
//    public boolean register(RegisterReq registerReq) {
//        if (userService.userExists(registerReq.getEmail()).isPresent()) {
//            return false;
//        }
//
//        String encodedPassword = encoder.encode(registerReq.getPassword());
//        registerReq.setPassword(encodedPassword);
//        userService.createUser(registerReq);
//        return true;
//    }
//}
