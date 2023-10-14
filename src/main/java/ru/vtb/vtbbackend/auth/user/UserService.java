package ru.vtb.vtbbackend.auth.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vtb.vtbbackend.exceptions.UserNotFoundException;
import ru.vtb.vtbbackend.web.dto.request.RegisterRequest;
import ru.vtb.vtbbackend.web.dto.response.UserDtoResponse;
import ru.vtb.vtbbackend.web.mapper.UserMapper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDtoResponse getUser(Long id) throws UserNotFoundException {

        var user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id #" + id + " has not found!"));

        return new UserDtoResponse(user);
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
