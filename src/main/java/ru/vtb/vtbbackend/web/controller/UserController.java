package ru.vtb.vtbbackend.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vtb.vtbbackend.web.mapper.UserDto;
//import ru.vtb.vtbbackend.service.AuthService;
import ru.vtb.vtbbackend.domain.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
//    private final AuthService authService;

    @GetMapping("/{id}")
    UserDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

//    @PostMapping("/register")
//    ResponseEntity<?> createUser(@RequestBody RegisterReq request){
//        if (authService.register(request)) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//    }
}
