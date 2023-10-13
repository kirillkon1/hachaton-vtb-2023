package ru.vtb.vtbbackend.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vtb.vtbbackend.domain.entity.Atm;
import ru.vtb.vtbbackend.domain.service.AtmService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/atms")
public class AtmController {
    private final AtmService atmService;

    @GetMapping()
    List<Atm> getAllAtms(){
        return atmService.getAll();
    }
}
