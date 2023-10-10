package ru.vtb.vtbbackend.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.vtb.vtbbackend.dto.BankDto;
import ru.vtb.vtbbackend.entity.Bank;

public interface BankMapper {
    BankMapper INSTANCE = Mappers.getMapper(BankMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "name", target = "name")
    @Mapping(expression = "java(CoordMapper.INSTANCE.coordinatesToCoordinatesDto(bank.getCoords()))",
            target = "coords")
    @Mapping(expression = "java(bank.getDepartments()" +
            ".stream.map(DepMapper.INSTANCE::departmentToDepartmentDto).toList())",
            target = "departments")
    BankDto bankToBankDto(Bank bank);
}
