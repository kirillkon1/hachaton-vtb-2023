package ru.vtb.vtbbackend.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vtb.vtbbackend.exceptions.BankNotFoundException;
import ru.vtb.vtbbackend.web.dto.request.BankFilterDtoRequest;
import ru.vtb.vtbbackend.web.dto.request.bankRequest.BankDtoRequest;
import ru.vtb.vtbbackend.web.dto.response.BankDtoPageableDto;
import ru.vtb.vtbbackend.web.dto.response.BankDtoResponse;
import ru.vtb.vtbbackend.domain.service.BankService;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;

    @GetMapping("/{id}")
    public BankDtoResponse getBank(@PathVariable Long id) throws BankNotFoundException {
        return bankService.getBank(id);
    }

//    @GetMapping
//    public List<BankDtoResponse> getAllBanks() {
//        return bankService.getAllBanks();
//    }

    @GetMapping
    public BankDtoPageableDto getAllBanks(
            @RequestParam(defaultValue = "10", name = "size") Integer size,
            @RequestParam(defaultValue = "0", name = "page") Integer page) {
        return bankService.getBankByPagination(size, page);
    }

    @PostMapping
    public BankDtoResponse createBank(@RequestBody @Valid BankDtoRequest dto) {
        return bankService.create(dto);
    }

    @PostMapping("/filter")
    public BankDtoPageableDto filterBanks(@RequestBody  BankFilterDtoRequest filterDto) {
        return bankService.filter(filterDto);
    }

    @DeleteMapping()
    public void delete() {
        bankService.deleteAll();
    }

}
