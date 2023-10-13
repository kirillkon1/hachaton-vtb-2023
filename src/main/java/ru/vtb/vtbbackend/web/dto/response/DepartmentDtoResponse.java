package ru.vtb.vtbbackend.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vtb.vtbbackend.domain.entity.Department;

public class DepartmentDtoResponse {

    public DepartmentDtoResponse(Department department) {
        this.name = department.getBankOffice().getName();
    }

    @JsonProperty("name")
    private String name;
}
