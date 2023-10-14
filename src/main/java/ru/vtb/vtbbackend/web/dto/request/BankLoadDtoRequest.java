package ru.vtb.vtbbackend.web.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BankLoadDtoRequest {

    @JsonProperty("bank_id")
    private Long bankId;

    private Double load;
    private LocalDateTime time;

}
