package ru.vtb.vtbbackend.web.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
public class BankFilterDtoRequest {

    @NotNull
    @JsonProperty("user_x")
    @Schema(name = "user_x", example = "10")
    private Double userX;

    @NotNull
    @JsonProperty("user_y")
    @Schema(name = "user_y", example = "20")
    private Double userY;

    @JsonProperty("departments")
    private List<String> departments;

    @JsonProperty("has_ramp")
    private boolean hasRamp;

    @NotNull
    @Schema(name = "page", example = "0", description = "Номер страницы")
    private Integer page;

    @NotNull
    @Schema(name = "size", example = "10", description = "Размер страницы")
    private Integer size;
}
