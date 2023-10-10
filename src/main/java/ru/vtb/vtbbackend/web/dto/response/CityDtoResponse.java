package ru.vtb.vtbbackend.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vtb.vtbbackend.domain.entity.City;


public class CityDtoResponse {

    public CityDtoResponse(City city) {
        this.name = city.getName();
    }

    @JsonProperty("name")
    private String name;
}
