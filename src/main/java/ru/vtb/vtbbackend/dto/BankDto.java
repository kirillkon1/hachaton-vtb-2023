package ru.vtb.vtbbackend.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class BankDto {
    private Long id;
    private String name;
    private String address;
    private Double rating;
    private CoordinatesDto coords;
    private CityDto city;
    private List<DepartmentDto> departments;
}
