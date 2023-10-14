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
import org.springframework.web.bind.annotation.*;
import ru.vtb.vtbbackend.exceptions.BankNotFoundException;
import ru.vtb.vtbbackend.web.errorHandler.ErrorResponse;
import ru.vtb.vtbbackend.web.dto.request.BankFilterDtoRequest;
import ru.vtb.vtbbackend.web.dto.request.bankRequest.BankDtoRequest;
import ru.vtb.vtbbackend.web.dto.response.BankDtoPageable;
import ru.vtb.vtbbackend.web.dto.response.BankDtoResponse;
import ru.vtb.vtbbackend.domain.service.BankService;

@RestController
@RequestMapping("/api/banks")
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;

    @GetMapping("/{id}")
    @Operation(summary = "Получить BankDtoResponse по Id банка")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
            content = { @Content(mediaType = "application/json", schema =
            @Schema(implementation = BankDtoResponse.class)) }),

            @ApiResponse(responseCode = "404", description = "Bank is not found",
                    content = {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = ErrorResponse.class)) }
            )
    })
    public BankDtoResponse getBank(
            @Parameter(name = "id", description = "Bank id", example = "1")
            @PathVariable Long id
    ) throws BankNotFoundException {
        return bankService.getBank(id);
    }

//    @GetMapping
//    public List<BankDtoResponse> getAllBanks() {
//        return bankService.getAllBanks();
//    }

    @GetMapping
    @Operation(summary = "Получить BankDtoPageableDto по BankFilterDtoRequest", description = "Поиск ближайших банков по фильтрации")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),

    })
    public BankDtoPageable getAllBanks(
            @RequestParam(defaultValue = "10", name = "size") Integer size,
            @RequestParam(defaultValue = "0", name = "page") Integer page) {
        return bankService.getBankByPagination(size, page);
    }

    @Hidden
    @PostMapping
    public BankDtoResponse createBank(@RequestBody @Valid BankDtoRequest dto) {
        return bankService.create(dto);
    }

    @PostMapping("/filter")
    @Operation(summary = "Получить BankDtoPageableDto по BankFilterDtoRequest", description = "Поиск ближайших банков по фильтрации")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success")
    })
    public BankDtoPageable filterBanks(@RequestBody BankFilterDtoRequest filterDto) {
        return bankService.filter(filterDto);
    }

    @PostMapping("/filter-2")
    @Operation(summary = "Получить BankDtoPageableDto по BankFilterDtoRequest", description = "Поиск ближайших банков по фильтрации")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success")
    })
    public BankDtoPageable filterBanks2(@RequestBody BankFilterDtoRequest filterDto) {
        return bankService.filter2(filterDto);
    }

    @Hidden
    @DeleteMapping()
    public void delete() {
        bankService.deleteAll();
    }

}
