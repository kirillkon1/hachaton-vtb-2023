package ru.vtb.vtbbackend.web.dto.request.bankRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class DepartmentDtoRequest {

    @JsonProperty("service_of_bank")
    private String serviceOfBank;

    @JsonProperty("open_hours_list")
    private List<OpenHoursRequest> openHoursList;

}
