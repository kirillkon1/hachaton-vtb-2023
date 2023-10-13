package ru.vtb.vtbbackend.web.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vtb.vtbbackend.web.dto.response.AtmDtoResponse;

import java.util.List;

//delete
public class AtmDtoRequest {
    @JsonProperty("atms")
    private List<AtmDtoResponse> atms;

    public List<AtmDtoResponse> getList() {
        return atms;
    }
}
