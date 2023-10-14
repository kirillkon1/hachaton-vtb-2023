package ru.vtb.vtbbackend.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.vtb.vtbbackend.domain.entity.Atm;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtmDtoResponse that = (AtmDtoResponse) o;
        return Objects.equals(address, that.address) && Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude) && Objects.equals(allDay, that.allDay) && Objects.equals(service, that.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, latitude, longitude, allDay, service);
    }
}
