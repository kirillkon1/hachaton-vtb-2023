package ru.vtb.vtbbackend.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.vtb.vtbbackend.domain.entity.Atm;

@Data
public class AtmDtoResponse {
    @JsonProperty("address")
    private String address;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("allDay")
    private Boolean allDay;
    @JsonProperty("services")
    private AtmInnerServicesDtoResponse service;

    public AtmDtoResponse() {
    }

    public AtmDtoResponse(String address, Double latitude, Double longitude, Boolean allDay, AtmInnerServicesDtoResponse service) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.allDay = allDay;
        this.service = service;
    }

    public AtmDtoResponse(Atm atm) {
        this.address = atm.getAddress();
        this.latitude = atm.getLatitude();
        this.longitude = atm.getLongitude();
        this.allDay = atm.getAllDay();
        this.service = new AtmInnerServicesDtoResponse(atm.getService());
    }
}
