package ru.vtb.vtbbackend.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vtb.vtbbackend.domain.repository.CityRepository;
import ru.vtb.vtbbackend.web.dto.response.CityDtoResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public List<CityDtoResponse> getAllCities() {
        return cityRepository.findAll().stream().map(CityDtoResponse::new).toList();
    }
}
