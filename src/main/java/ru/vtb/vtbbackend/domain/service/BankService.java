package ru.vtb.vtbbackend.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.vtb.vtbbackend.domain.entity.Bank;
import ru.vtb.vtbbackend.domain.entity.Department;
import ru.vtb.vtbbackend.domain.entity.OpenHours;
import ru.vtb.vtbbackend.domain.repository.ServiceOfBankRepository;
import ru.vtb.vtbbackend.domain.repository.BankRepository;
import ru.vtb.vtbbackend.exceptions.BankNotFoundException;
import ru.vtb.vtbbackend.exceptions.CustomNotFoundException;
import ru.vtb.vtbbackend.web.dto.request.BankFilterDtoRequest;
import ru.vtb.vtbbackend.web.dto.request.bankRequest.BankDtoRequest;
import ru.vtb.vtbbackend.web.dto.response.BankDtoPageable;
import ru.vtb.vtbbackend.web.dto.response.BankDtoResponse;


import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;
    public final ServiceOfBankRepository serviceRepository;

    public BankDtoResponse getBank(Long id) throws BankNotFoundException {
        var bank = bankRepository.findById(id).orElseThrow(() -> new BankNotFoundException("Bank hasn't been found with id: " + id));
        return new BankDtoResponse(bank);

    }

    public List<BankDtoResponse> getAllBanks() {
        return bankRepository.findAll().stream().map(BankDtoResponse::new).toList();
    }

    public BankDtoPageable getBankByPagination(Integer size, Integer page) {
        Pageable pageable = PageRequest.of(page, size);

        System.out.println(pageable);
        var banks = bankRepository.findAll(pageable);
        var bankDtos = banks.stream().map(BankDtoResponse::new).toList();

        return BankDtoPageable.builder()
                .banks(bankDtos)
                .page(Long.valueOf(page))
                .pageSize(Long.valueOf(size))
                .total(banks.getTotalElements())
                .totalPages((long) banks.getTotalPages())
                .build();


    }


    public BankDtoPageable filter(BankFilterDtoRequest filterDto) {
        Pageable pageable = PageRequest.of(filterDto.getPage(), filterDto.getSize());

        var banks = bankRepository.findNearestBanks(filterDto.getUserX(), filterDto.getUserY(), pageable);
        var bankDtos = banks.stream().map(BankDtoResponse::new).toList();

        return BankDtoPageable.builder()
                .banks(bankDtos)
                .page(Long.valueOf(filterDto.getPage()))
                .pageSize(Long.valueOf(filterDto.getSize()))
                .total(banks.getTotalElements())
                .totalPages((long) banks.getTotalPages())
                .build();


    }

    public BankDtoResponse create(BankDtoRequest dto){

        List<Department> newDepartments = dto.getDepartments().stream().map(
                it -> {
                    try {
                        return Department.builder()
                                .serviceOfBank(serviceRepository.findByName(it.getServiceOfBank()).orElseThrow(
                                        () -> new CustomNotFoundException("Bank office #" + it.getServiceOfBank() + " hasn't been found!")
                                ))

                                .openHours((
                                        it.getOpenHoursList().stream().map(it2 ->
                                                OpenHours.builder()
                                                        .openAt(it2.getOpenAt())
                                                        .closedAt(it2.getClosedAt())
                                                        .dayOfWeek(it2.getDayOfWeek().toUpperCase())
                                                        .build()
                                        ).toList()
                                ))
                                .build();
                    } catch (CustomNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).toList();

        var bank = Bank
                .builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .longitude(dto.getLongitude())
                .latitude(dto.getLatitude())
                .phoneNumber(dto.getPhoneNumber())
                .rko(dto.isRko())
                .hasRamp(dto.isHasRamp())
                .departments(newDepartments)
                .build();



        var newBank = bankRepository.save(bank);
        return new BankDtoResponse(newBank);

    }

    private Integer parseTime(String time){
        return Integer.parseInt(time.replace(":", ""));
    }

    public void deleteAll() {
        bankRepository.deleteAll();
    }


}
