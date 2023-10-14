package ru.vtb.vtbbackend.web.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtmFilterDtoRequest {

    @NotNull
    @JsonProperty("user_latitude")
    private Double userLatitude;
    @NotNull
    @JsonProperty("user_longitude")
    private Double userLongitude;
    @NotNull
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("size")
    @NotNull
    private Integer size;

}
