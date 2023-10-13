package ru.vtb.vtbbackend.web.dto.request.bankRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class OpenHoursRequest {

    @JsonProperty("open_at")
    private String openAt;

    @JsonProperty("closed_at")
    private String closedAt;

    @JsonProperty("day_of_week")
    private String dayOfWeek;
}
