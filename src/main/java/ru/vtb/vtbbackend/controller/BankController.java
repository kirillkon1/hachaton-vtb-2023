package ru.vtb.vtbbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vtb.vtbbackend.dto.BankDto;
import ru.vtb.vtbbackend.service.BankService;

import java.util.List;

@RestController
@RequestMapping("/bank")
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;

    @GetMapping("/get-bank/{id}")
    ResponseEntity<BankDto> getBank(@PathVariable long id){
        return ResponseEntity.ok(bankService.getBank(id));
    }

    @GetMapping("/get-all")
    ResponseEntity<List<BankDto>> getAllBanks(){
        return ResponseEntity.ok(bankService.getAllBanks());
    }
}
