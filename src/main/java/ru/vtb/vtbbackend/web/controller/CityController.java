package ru.vtb.vtbbackend.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vtb.vtbbackend.domain.service.CityService;
import ru.vtb.vtbbackend.web.dto.response.CityDtoResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;

    @GetMapping
    List<CityDtoResponse> getAllCities() {
        return cityService.getAllCities();
    }
}
