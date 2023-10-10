package ru.vtb.vtbbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vtb.vtbbackend.dto.RegisterReq;
import ru.vtb.vtbbackend.dto.UserDto;
import ru.vtb.vtbbackend.service.AuthService;
import ru.vtb.vtbbackend.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AuthService authService;

    @GetMapping("/get/{id}")
    ResponseEntity<UserDto> readUser(@PathVariable long id){
        return ResponseEntity.ok(userService.readUser(id));
    }

    @PostMapping("/register")
    ResponseEntity<?> createUser(@RequestBody RegisterReq request){
        if (authService.register(request)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
