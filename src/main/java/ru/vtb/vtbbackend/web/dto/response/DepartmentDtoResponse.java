package ru.vtb.vtbbackend.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vtb.vtbbackend.domain.entity.Department;
import ru.vtb.vtbbackend.domain.entity.OpenHours;

import java.util.List;

public class DepartmentDtoResponse {

    public DepartmentDtoResponse(Department department) {
        this.name = department.getServiceOfBank().getName();
        this.openHours = department.getOpenHours();
    }

    @JsonProperty("name")
    private String name;

    @JsonProperty("open_hours")
    private List<OpenHours> openHours;

}
