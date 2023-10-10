package ru.vtb.vtbbackend.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.vtb.vtbbackend.dto.CityDto;
import ru.vtb.vtbbackend.entity.City;

public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    CityDto cityToCityDto(City city);
}
