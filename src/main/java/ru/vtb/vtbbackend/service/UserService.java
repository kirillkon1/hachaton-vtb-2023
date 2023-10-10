package ru.vtb.vtbbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vtb.vtbbackend.dto.RegisterReq;
import ru.vtb.vtbbackend.dto.UserDto;
import ru.vtb.vtbbackend.entity.User;
import ru.vtb.vtbbackend.mapper.UserMapper;
import ru.vtb.vtbbackend.repository.UserRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto readUser(long id) {
        return UserMapper.INSTANCE.userToUserDto(userRepository.findById(id)
                .orElse(null));
    }

    public void createUser(RegisterReq request) {
        User user = UserMapper.INSTANCE.registerReqToUser(request);
        user.setCreatedAt(LocalDate.now());
        userRepository.save(user);
    }

    public Optional<User> userExists(String email) {
        return userRepository.findByEmail(email);
    }
}
