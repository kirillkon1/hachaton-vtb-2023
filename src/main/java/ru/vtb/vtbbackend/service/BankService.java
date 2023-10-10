package ru.vtb.vtbbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vtb.vtbbackend.dto.BankDto;
import ru.vtb.vtbbackend.mapper.BankMapper;
import ru.vtb.vtbbackend.repository.BankRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {
    private final BankRepository bankRepository;

    public BankDto getBank(long id){
        return BankMapper.INSTANCE.bankToBankDto(
                bankRepository.findById(id).orElse(null));
    }

    public List<BankDto> getAllBanks(){
        return bankRepository.findAll()
                .stream()
                .map(BankMapper.INSTANCE::bankToBankDto)
                .toList();
    }
}
