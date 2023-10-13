package ru.vtb.vtbbackend.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vtb.vtbbackend.exceptions.BankNotFoundException;
import ru.vtb.vtbbackend.web.dto.request.BankFilterDtoRequest;
import ru.vtb.vtbbackend.web.dto.request.bankRequest.BankDtoRequest;
import ru.vtb.vtbbackend.web.dto.response.BankDtoResponse;
import ru.vtb.vtbbackend.domain.service.BankService;

import java.util.List;

@RestController
@RequestMapping("/banks")
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;

    @GetMapping("/{id}")
    public BankDtoResponse getBank(@PathVariable Long id) throws BankNotFoundException {
        return bankService.getBank(id);
    }

    @GetMapping
    public List<BankDtoResponse> getAllBanks() {
        return bankService.getAllBanks();
    }

    @PostMapping()
    public BankDtoResponse createBank(BankDtoRequest dto){
        return bankService.create(dto);
    }

    @PostMapping("/filter")
    public List<BankDtoResponse> filterBanks(@RequestBody @Valid BankFilterDtoRequest filterDto){
        return bankService.filter(filterDto);
    }

}
