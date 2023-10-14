package ru.vtb.vtbbackend.web.dto.request.bankRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;

@Getter
public class DepartmentDtoRequest {

    @JsonProperty("service_of_bank")
    @Schema(name = "услуги банка", example = "openHoursIndividual",
            description = "Тип услуг банка. Может быть openHours (для юр лиц) и openHoursIndividual (для физ лиц) ")
    private String serviceOfBank;

    @JsonProperty("open_hours_list")
    @Schema(name = "Время работы банка")
    private List<OpenHoursRequest> openHoursList;

}
