package ru.vtb.vtbbackend.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vtb.vtbbackend.exceptions.BankNotFoundException;
import ru.vtb.vtbbackend.web.dto.response.BankDtoResponse;
import ru.vtb.vtbbackend.domain.service.BankService;

import java.util.List;

@RestController
@RequestMapping("/banks")
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;

    @GetMapping("/{id}")
    BankDtoResponse getBank(@PathVariable Long id) throws BankNotFoundException {
        return bankService.getBank(id);
    }

    @GetMapping
    List<BankDtoResponse> getAllBanks() {
        return bankService.getAllBanks();
    }
}
