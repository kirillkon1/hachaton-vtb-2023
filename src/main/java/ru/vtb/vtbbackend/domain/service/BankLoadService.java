package ru.vtb.vtbbackend.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vtb.vtbbackend.domain.entity.Bank;
import ru.vtb.vtbbackend.domain.entity.BankLoad;
import ru.vtb.vtbbackend.domain.repository.BankLoadRepository;
import ru.vtb.vtbbackend.domain.repository.BankRepository;
import ru.vtb.vtbbackend.exceptions.CustomNotFoundException;
import ru.vtb.vtbbackend.web.dto.request.BankLoadDtoRequest;

@Service
@RequiredArgsConstructor
public class BankLoadService {

    private final BankRepository bankRepository;
    private final BankLoadRepository loadRepository;

    public BankLoad createLoad(BankLoadDtoRequest dto) throws CustomNotFoundException {
        var bankOpt = bankRepository.findById(dto.getBankId());

        Bank bank;

        if (bankOpt.isPresent()) {
            bank = bankOpt.get();
        } else {
            throw new CustomNotFoundException("Bank with id#" + dto.getBankId() + " not found!");
        }

        BankLoad load = new BankLoad(dto.getLoad(),dto.getTime(), bank);

        return loadRepository.save(load);
    }
}
