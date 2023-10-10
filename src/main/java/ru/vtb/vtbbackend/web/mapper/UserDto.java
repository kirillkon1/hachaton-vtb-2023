package ru.vtb.vtbbackend.web.mapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
}
