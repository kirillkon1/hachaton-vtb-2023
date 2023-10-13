package ru.vtb.vtbbackend.web.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RegisterRequest {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
}
