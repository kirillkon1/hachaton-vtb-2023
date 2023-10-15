package ru.vtb.vtbbackend.web.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.vtb.vtbbackend.exceptions.BankNotFoundException;
import ru.vtb.vtbbackend.exceptions.CustomNotFoundException;
import ru.vtb.vtbbackend.web.dto.response.BankLoadDtoPageableResponse;
import ru.vtb.vtbbackend.web.errorHandler.ErrorResponse;
import ru.vtb.vtbbackend.web.dto.request.BankFilterDtoRequest;
import ru.vtb.vtbbackend.web.dto.request.bankRequest.BankDtoRequest;
import ru.vtb.vtbbackend.web.dto.response.BankDtoPageableResponse;
import ru.vtb.vtbbackend.web.dto.response.BankDtoResponse;
import ru.vtb.vtbbackend.domain.service.BankService;

@RestController
@RequestMapping("/api/banks")
@RequiredArgsConstructor
@Slf4j
public class BankController {
    private final BankService bankService;

    @Operation(summary = "Получить BankDtoResponse по Id банка", tags = "Bank",
            description = "получение информации о банке по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = BankDtoResponse.class))}),

            @ApiResponse(responseCode = "404", description = "Bank is not found",
                    content = {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = ErrorResponse.class))}
            )
    })
    @GetMapping("/{id}")
    public BankDtoResponse getBank(
            @Parameter(name = "id", description = "Bank id", example = "1")
            @PathVariable Long id
    ) throws BankNotFoundException {
        return bankService.getBank(id);
    }


    @Operation(summary = "Получить BankLoadDtoPageableResponse по Id банка", tags = "Bank",
            description = "получение информации о банке по id и его уровня загруженности")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = BankLoadDtoPageableResponse.class))}),

            @ApiResponse(responseCode = "404", description = "Bank is not found",
                    content = {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = ErrorResponse.class))}
            )
    })
    @GetMapping("/{id}/loads")
    public BankLoadDtoPageableResponse getBankWithLoads(
            @Parameter(name = "id", description = "Bank id", example = "1") @PathVariable Long id,
            @RequestParam(defaultValue = "10", name = "size") Integer size,
            @RequestParam(defaultValue = "0", name = "page") Integer page
    ) throws CustomNotFoundException {
        return bankService.getBankLoad(id, page, size);
    }


//    @GetMapping
//    public List<BankDtoResponse> getAllBanks() {
//        return bankService.getAllBanks();
//    }


    @Operation(summary = "Получить BankDtoPageableResponse", tags = "Bank",
            description = "получение всех банков с пагинацией")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = BankDtoPageableResponse.class))})
    })
    @GetMapping()
    public BankDtoPageableResponse getAllBanks(
            @RequestParam(defaultValue = "10", name = "size") Integer size,
            @RequestParam(defaultValue = "0", name = "page") Integer page) {


        return bankService.getBankByPagination(size, page);
    }

    @Hidden
    @PostMapping
    public BankDtoResponse createBank(@RequestBody @Valid BankDtoRequest dto) {
        log.info("Creating bank with name#" + dto.getName());
        return bankService.create(dto);
    }


    @Operation(summary = "Получить BankDtoPageableResponse по BankFilterDtoRequest", tags = "Bank",
            description = "Поиск ближайших банков по фильтрации")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = BankDtoPageableResponse.class))})
    })
    @PostMapping("/filter")
    public BankDtoPageableResponse filterBanks(@RequestBody BankFilterDtoRequest filterDto) {
        return bankService.filter(filterDto);
    }

//    @Operation(summary = "Получить BankDtoPageableResponse по BankFilterDtoRequest", tags = "Bank",
//            description = "Поиск ближайших банков с фильтрацией по ramp и department")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Success",
//                    content = {@Content(mediaType = "application/json", schema =
//                    @Schema(implementation = BankDtoPageableResponse.class))})
//    })
//    @PostMapping("/filter-2")
//    public BankDtoPageableResponse filterBanks2(@RequestBody BankFilterDtoRequest filterDto) {
//        return bankService.filter2(filterDto);
//    }

    @Hidden
    @DeleteMapping()
    public void delete() {
        bankService.deleteAll();
    }
}
