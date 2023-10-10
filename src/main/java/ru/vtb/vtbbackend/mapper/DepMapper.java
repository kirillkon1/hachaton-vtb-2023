package ru.vtb.vtbbackend.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.vtb.vtbbackend.dto.DepartmentDto;
import ru.vtb.vtbbackend.entity.Department;

public interface DepMapper {
    DepMapper INSTANCE = Mappers.getMapper(DepMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    DepartmentDto departmentToDepartmentDto(Department department);
}
