package ru.vtb.vtbbackend.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RegisterReq {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
}
