package ru.vtb.vtbbackend.web.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.vtb.vtbbackend.web.dto.response.DepartmentDtoResponse;
import ru.vtb.vtbbackend.domain.entity.Department;

public interface DepMapper {
    DepMapper INSTANCE = Mappers.getMapper(DepMapper.class);

    @Mapping(source = "name", target = "name")
    DepartmentDtoResponse departmentToDepartmentDto(Department department);
}
