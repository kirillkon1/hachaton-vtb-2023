package ru.vtb.vtbbackend.web.dto.request.bankRequest;
import lombok.Getter;

import java.util.List;

@Getter
public class DepartmentDtoRequest {

    private String serviceName;
    private List<WorkingTimeDtoRequest> workingTimeDtoList;

}
