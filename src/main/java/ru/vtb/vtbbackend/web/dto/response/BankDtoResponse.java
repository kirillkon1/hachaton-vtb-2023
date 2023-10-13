package ru.vtb.vtbbackend.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vtb.vtbbackend.domain.entity.Bank;

import java.util.List;


public class BankDtoResponse {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("coordinate")
    private CoordinatesDtoResponse coords;
    @JsonProperty("city")
    private String city;
    @JsonProperty("departments")
    private List<DepartmentDtoResponse> departments;


    public BankDtoResponse(Bank bank) {
        this.id = bank.getId();
        this.name = bank.getName();
        this.address = bank.getAddress();
        this.rating = bank.getRating();
        this.coords = new CoordinatesDtoResponse(bank.getCoords());
        this.city = bank.getCity().getName();
        this.departments = bank.getDepartments().stream().map(DepartmentDtoResponse::new).toList();
    }

}
