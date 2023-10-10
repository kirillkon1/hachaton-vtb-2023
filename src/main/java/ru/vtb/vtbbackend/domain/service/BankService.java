package ru.vtb.vtbbackend.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vtb.vtbbackend.domain.repository.BankRepository;
import ru.vtb.vtbbackend.exceptions.BankNotFoundException;
import ru.vtb.vtbbackend.web.dto.response.BankDtoResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;

    public BankDtoResponse getBank(Long id) throws BankNotFoundException {
        var bank = bankRepository.findById(id).orElseThrow(() -> new BankNotFoundException("Bank hasn't been found with id: " + id));
        return new BankDtoResponse(bank);

    }

    public List<BankDtoResponse> getAllBanks() {
        return bankRepository.findAll().stream().map(BankDtoResponse::new).toList();
    }
}
