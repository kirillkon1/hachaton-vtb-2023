package ru.vtb.vtbbackend.web.dto.request.bankRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.vtb.vtbbackend.domain.entity.City;
import ru.vtb.vtbbackend.domain.entity.Coordinates;

import java.util.List;

@Getter
public class BankDtoRequest {


    private String name;
    private String address;

    private Double rating;

    private Coordinates coords;
    private City city;

    private List<DepartmentDtoRequest> departments;

    @JsonProperty("phone_number")
    private String phoneNumber;




}
