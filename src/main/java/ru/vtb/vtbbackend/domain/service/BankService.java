package ru.vtb.vtbbackend.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.vtb.vtbbackend.domain.entity.Bank;
import ru.vtb.vtbbackend.domain.entity.Department;
import ru.vtb.vtbbackend.domain.entity.OpenHours;
import ru.vtb.vtbbackend.domain.repository.ServiceOfBankRepository;
import ru.vtb.vtbbackend.domain.repository.BankRepository;
import ru.vtb.vtbbackend.exceptions.BankNotFoundException;
import ru.vtb.vtbbackend.web.dto.request.BankFilterDtoRequest;
import ru.vtb.vtbbackend.web.dto.request.bankRequest.BankDtoRequest;
import ru.vtb.vtbbackend.web.dto.response.BankDtoResponse;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public List<BankDtoResponse> filter(BankFilterDtoRequest filterDto) {
        return null;
    }

    public BankDtoResponse create(BankDtoRequest dto) {

        List<Department> newDepartments = dto.getDepartments().stream().map(
                it -> Department.builder()
                        .serviceOfBank(serviceRepository.findByName(it.getServiceOfBank()).orElseThrow(
                                () -> new NotFoundException("Bank office #" + it.getServiceOfBank() + " has been found!")
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
                        .build()
        ).toList();

        var bank = Bank
                .builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .longitude(dto.getLongitude())
                .latitude(dto.getLatitude())
                .departments(newDepartments)
                .build();



        var newBank = bankRepository.save(bank);
        return new BankDtoResponse(newBank);

    }

    private Integer parseTime(String time){
        return Integer.parseInt(time.replace(":", ""));
    }
}
