package ru.vtb.vtbbackend.web.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vtb.vtbbackend.domain.service.AtmService;
import ru.vtb.vtbbackend.web.dto.request.AtmDtoRequest;
import ru.vtb.vtbbackend.web.dto.request.AtmFilterDtoRequest;
import ru.vtb.vtbbackend.web.dto.response.AtmDtoPageableDto;
import ru.vtb.vtbbackend.web.dto.response.AtmDtoResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/atms")
public class AtmController {
    private final AtmService atmService;

    @GetMapping()
    List<AtmDtoResponse> getAtms(){
        return atmService.getAll();
    }

    @GetMapping(params = {"page", "size"})
    AtmDtoPageableDto getAtms(@RequestParam Integer page, @RequestParam Integer size){
        return atmService.getAll(page, size);
    }

    //delete
    @Hidden
    @PostMapping()
    ResponseEntity<?> uploadAtms(@RequestBody AtmDtoRequest list){
        atmService.upload(list);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/filter")
    AtmDtoPageableDto getFilteredAtms(@RequestBody AtmFilterDtoRequest request){
        return atmService.getFiltered(request);
    }
}
