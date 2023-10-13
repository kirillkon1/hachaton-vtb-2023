package ru.vtb.vtbbackend.web.dto.request.bankRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;


import java.util.List;

@Getter
@ToString
public class BankDtoRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String address;

    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private Double rating;

    private boolean status;
    private boolean rko;

    @JsonProperty("sale_point_format")
    private String salePointFormat;

    private List<DepartmentDtoRequest> departments;

    @JsonProperty("json_info")
    private String jsonInfo;

}
