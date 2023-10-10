package ru.vtb.vtbbackend.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.vtb.vtbbackend.dto.CoordinatesDto;
import ru.vtb.vtbbackend.entity.Coordinates;

public interface CoordMapper {
    CoordMapper INSTANCE = Mappers.getMapper(CoordMapper.class);

    @Mapping(source = "latitude", target = "latitude")
    @Mapping(source = "longitude", target = "longitude")
    CoordinatesDto coordinatesToCoordinatesDto(Coordinates coordinates);
}
