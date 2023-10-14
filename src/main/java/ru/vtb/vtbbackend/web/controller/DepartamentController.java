package ru.vtb.vtbbackend.web.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vtb.vtbbackend.web.dto.response.DepartmentDtoResponse;
import ru.vtb.vtbbackend.domain.service.DepartamentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
@Hidden
public class DepartamentController {
    private final DepartamentService departamentService;

    @GetMapping
    List<DepartmentDtoResponse> getAllDepartments() {
        return departamentService.getAllDepartments();
    }
}
