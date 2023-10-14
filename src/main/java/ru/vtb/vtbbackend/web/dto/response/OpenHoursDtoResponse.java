package ru.vtb.vtbbackend.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vtb.vtbbackend.domain.entity.OpenHours;

public class OpenHoursDtoResponse {

    public OpenHoursDtoResponse(OpenHours openHours) {
        this.dayOfWeek = openHours.getDayOfWeek();

        if (openHours.getOpenAt().equals("0:00")){
            this.openAt = "выходной";
        }else{
            this.openAt = openHours.getOpenAt();
        }

        if (openHours.getClosedAt().equals("0:00")){
            this.closedAt = "выходной";
        }else{
            this.closedAt = openHours.getClosedAt();
        }

    }


    @JsonProperty(value = "open_at")
    private String openAt;

    @JsonProperty(value = "closed_at")
    private String closedAt;

    @JsonProperty(value = "day_of_the_week")
    private String dayOfWeek;

}
