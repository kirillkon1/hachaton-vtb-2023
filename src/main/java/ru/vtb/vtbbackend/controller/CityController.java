package ru.vtb.vtbbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vtb.vtbbackend.dto.CityDto;
import ru.vtb.vtbbackend.service.CityService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    @GetMapping("/get-all")
    ResponseEntity<List<CityDto>> getAllCities(){
        return ResponseEntity.ok(cityService.getAllCities());
    }
}
