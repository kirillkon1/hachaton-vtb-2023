package ru.vtb.vtbbackend.web.dto.request.bankRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;


@Getter
@Schema(name = "Dto-ответ для времени работы банка")
public class OpenHoursRequest {

    @JsonProperty("open_at")
    @Schema(name = "Время открытия филиала банка", example = "8:00")
    private String openAt;

    @JsonProperty("closed_at")
    @Schema(name = "Время закрытия филиала банка", example = "18:00")
    private String closedAt;

    @JsonProperty("day_of_week")
    @Schema(name = "День недели", example = "ПОНЕДЕЛЬНИК")
    private String dayOfWeek;
}
