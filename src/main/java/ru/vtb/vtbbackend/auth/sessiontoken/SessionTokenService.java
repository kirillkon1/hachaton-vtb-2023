//package ru.vtb.vtbbackend.auth.sessiontoken;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import ru.vtb.vtbbackend.auth.user.User;
//
//import java.time.LocalDateTime;
//
//@Service
//@RequiredArgsConstructor
//public class SessionTokenService {
//
//    private final SessionTokenRepository sessionTokenRepository;
//    private final PasswordEncoder encoder;
//
//    public String generateSession(User user){
//        var session = SessionToken.builder()
//                .user(user)
//                .session(
//                        "60min_" + encoder.encode(user.getName()
//                                + Integer.parseInt(String.valueOf(1000000 * Math.random())))
//                )
//                .expiredAt(LocalDateTime.now().plusMinutes(60))
//                .build();
//
//        return session;
//    }
//
//    public User getUserBySessionToken(String token){
//
//    }
//
//
//}
