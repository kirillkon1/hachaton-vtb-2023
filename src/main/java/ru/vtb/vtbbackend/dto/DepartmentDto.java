package ru.vtb.vtbbackend.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DepartmentDto {
    private Long id;
    private String name;
}
