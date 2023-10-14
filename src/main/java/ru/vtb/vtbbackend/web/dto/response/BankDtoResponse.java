package ru.vtb.vtbbackend.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import ru.vtb.vtbbackend.domain.entity.Bank;
import ru.vtb.vtbbackend.domain.entity.MetroStation;

import java.util.List;


public class BankDtoResponse {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("departments")
    private List<DepartmentDtoResponse> departments;


    private String status;
    private String rko;
    @JsonProperty("has_ramp")
    private boolean hasRamp;

    @JsonProperty("sale_point_format")
    private String salePointFormat;

    @JsonProperty("metro_station")
    private String metroStation;

    @JsonProperty("phone_number")
    private String phoneNumber;


    public BankDtoResponse(Bank bank) {
        this.id = bank.getId();
        this.name = bank.getName();
        this.address = bank.getAddress();
        this.longitude = bank.getLongitude();
        this.latitude = bank.getLatitude();
        this.departments = bank.getDepartments().stream().map(DepartmentDtoResponse::new).toList();
        this.hasRamp = bank.isHasRamp();

        this.status = bank.isStatus() ? "открыта" : "закрыта";
        this.rko = bank.isRko() ? "есть РКО" : "нет РКО";

        if (bank.getMetroStation() != null){
            this.metroStation = bank.getMetroStation().getName();
        }
        this.phoneNumber = bank.getPhoneNumber();
    }

}
