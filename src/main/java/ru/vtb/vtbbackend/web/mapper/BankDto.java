package ru.vtb.vtbbackend.web.mapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.vtb.vtbbackend.web.dto.response.DepartmentDtoResponse;

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
    private List<DepartmentDtoResponse> departments;
}
