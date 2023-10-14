package ru.vtb.vtbbackend.web.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vtb.vtbbackend.domain.service.AtmService;
import ru.vtb.vtbbackend.web.dto.request.AtmDtoRequest;
import ru.vtb.vtbbackend.web.dto.request.AtmFilterDtoRequest;
import ru.vtb.vtbbackend.web.dto.response.AtmDtoPageableResponse;
import ru.vtb.vtbbackend.web.dto.response.AtmDtoResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/atms")
public class AtmController {
    private final AtmService atmService;


    @Operation(summary = "Получить список AtmDtoResponse", tags = "Atm",
            description = "получение списка всех банкоматов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = AtmDtoResponse.class))}),
    })
    @GetMapping()
    List<AtmDtoResponse> getAtms() {
        return atmService.getAll();
    }


    @Operation(summary = "Получить AtmDtoPageableDto", tags = "Atm",
            description = "получение списка ближайших банкоматов с пагинацией")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = AtmDtoPageableResponse.class))}),
    })
    @GetMapping(params = {"page", "size"})
    AtmDtoPageableResponse getAtms(@RequestParam(defaultValue = "0") Integer page,
                                   @RequestParam(defaultValue = "10") Integer size) {
        return atmService.getAll(page, size);
    }

    //delete
    @Hidden
    @PostMapping()
    ResponseEntity<?> uploadAtms(@RequestBody AtmDtoRequest list) {
        atmService.upload(list);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Получить AtmDtoPageableResponse по AtmFilterDtoRequest", tags = "Atm",
            description = "получение списка ближайших банкоматов с пагинацией")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = AtmDtoPageableResponse.class))}),
    })
    @PostMapping("/filter")
    AtmDtoPageableResponse getFilteredAtms(@RequestBody AtmFilterDtoRequest request) {
        return atmService.getFiltered(request);
    }
}
