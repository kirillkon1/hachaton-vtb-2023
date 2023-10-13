package ru.vtb.vtbbackend.web.dto.response;

import lombok.Data;
import ru.vtb.vtbbackend.domain.entity.Atm;

@Data
public class AtmDtoResponse {
    private String address;
    private Double latitude;
    private Double longitude;
    private boolean allDay;
    private AtmInnerServicesDtoResponse service;

    public AtmDtoResponse(Atm atm) {
        this.address = atm.getAddress();
        this.latitude = atm.getLatitude();
        this.longitude = atm.getLongitude();
        this.allDay = atm.getAllDay();
        this.service = new AtmInnerServicesDtoResponse(atm.getService());
    }
}
