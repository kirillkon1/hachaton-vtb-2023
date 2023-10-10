package ru.vtb.vtbbackend.web.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.vtb.vtbbackend.domain.entity.Coordinates;

public interface CoordMapper {
    CoordMapper INSTANCE = Mappers.getMapper(CoordMapper.class);

    @Mapping(source = "latitude", target = "latitude")
    @Mapping(source = "longitude", target = "longitude")
    CoordinatesDto coordinatesToCoordinatesDto(Coordinates coordinates);
}
