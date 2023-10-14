package ru.vtb.vtbbackend.web.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vtb.vtbbackend.domain.entity.BankLoad;
import ru.vtb.vtbbackend.domain.service.BankLoadService;
import ru.vtb.vtbbackend.exceptions.CustomNotFoundException;
import ru.vtb.vtbbackend.web.dto.request.BankLoadDtoRequest;

@RestController
@RequestMapping("api/loads")
@Hidden
@RequiredArgsConstructor
public class BankLoadController {

    private final BankLoadService loadService;

    @PostMapping
    public BankLoad create(@RequestBody BankLoadDtoRequest dto) throws CustomNotFoundException {
        return  loadService.createLoad(dto);

    }



}
