package ru.vtb.vtbbackend.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Hidden
public class TestDTO {

    @JsonProperty("json_info")
    private String jsonInfo;
}
