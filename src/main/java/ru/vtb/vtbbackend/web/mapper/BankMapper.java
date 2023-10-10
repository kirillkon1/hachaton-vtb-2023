package ru.vtb.vtbbackend.web.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.vtb.vtbbackend.domain.entity.Bank;

public interface BankMapper {
    BankMapper INSTANCE = Mappers.getMapper(BankMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "rating", target = "rating")
    @Mapping(expression = "java(CoordMapper.INSTANCE.coordinatesToCoordinatesDto(bank.getCoords()))",
            target = "coords")
    @Mapping(expression = "java(CityMapper.INSTANCE.cityToCityDto(bank.getCity()))",
            target = "coords")
    @Mapping(expression = "java(bank.getDepartments()" +
            ".stream.map(DepMapper.INSTANCE::departmentToDepartmentDto).toList())",
            target = "departments")
    BankDto bankToBankDto(Bank bank);
}
