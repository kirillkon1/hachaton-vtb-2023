package ru.vtb.vtbbackend.web.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import ru.vtb.vtbbackend.domain.entity.Department;

import java.util.List;

@Getter
public class BankFilterDtoRequest {

    @NotNull
    @JsonProperty("user_x")
    private Double userX;

    @NotNull
    @JsonProperty("user_y")
    private Double userY;


    private List<Department> departments;

    @NotNull private Integer page;
    @NotNull private Integer size;



}
