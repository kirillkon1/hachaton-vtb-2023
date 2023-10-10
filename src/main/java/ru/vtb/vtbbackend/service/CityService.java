package ru.vtb.vtbbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vtb.vtbbackend.dto.CityDto;
import ru.vtb.vtbbackend.mapper.CityMapper;
import ru.vtb.vtbbackend.repository.CityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public List<CityDto> getAllCities() {
        return cityRepository.findAll()
                .stream()
                .map(CityMapper.INSTANCE::cityToCityDto)
                .toList();
    }
}
