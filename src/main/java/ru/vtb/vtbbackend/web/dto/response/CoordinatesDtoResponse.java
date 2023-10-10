package ru.vtb.vtbbackend.web.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import ru.vtb.vtbbackend.domain.entity.Coordinates;

@AllArgsConstructor
public class CoordinatesDtoResponse {


    public CoordinatesDtoResponse(Coordinates coords) {
        this.latitude = coords.getLatitude();
        this.longitude = coords.getLongitude();
    }

    @JsonProperty("coord_x")
    private Double longitude;
    @JsonProperty("coord_y")
    private Double latitude;
}
