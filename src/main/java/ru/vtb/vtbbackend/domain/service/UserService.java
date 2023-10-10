package ru.vtb.vtbbackend.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vtb.vtbbackend.domain.entity.User;
import ru.vtb.vtbbackend.domain.repository.UserRepository;
import ru.vtb.vtbbackend.web.dto.request.RegisterRequest;
import ru.vtb.vtbbackend.web.mapper.UserDto;
import ru.vtb.vtbbackend.web.mapper.UserMapper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto getUser(long id) {
        return UserMapper.INSTANCE.userToUserDto(userRepository.findById(id)
                .orElse(null));
    }

    public void createUser(RegisterRequest request) {
        User user = UserMapper.INSTANCE.registerReqToUser(request);
//        user.setCreatedAt(LocalDate.now());
        userRepository.save(user);
    }

    public Optional<User> userExists(String email) {
        return userRepository.findByEmail(email);
    }
}
