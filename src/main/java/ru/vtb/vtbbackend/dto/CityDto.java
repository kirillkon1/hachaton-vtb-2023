package ru.vtb.vtbbackend.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CityDto {
    private Long id;
    private String name;
}
