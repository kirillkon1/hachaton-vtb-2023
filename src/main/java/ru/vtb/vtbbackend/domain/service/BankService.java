package ru.vtb.vtbbackend.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.vtb.vtbbackend.domain.entity.Bank;
import ru.vtb.vtbbackend.domain.entity.Coordinates;
import ru.vtb.vtbbackend.domain.entity.Department;
import ru.vtb.vtbbackend.domain.entity.WorkingTime;
import ru.vtb.vtbbackend.domain.repository.BankOfficeRepository;
import ru.vtb.vtbbackend.domain.repository.BankRepository;
import ru.vtb.vtbbackend.exceptions.BankNotFoundException;
import ru.vtb.vtbbackend.web.dto.request.BankFilterDtoRequest;
import ru.vtb.vtbbackend.web.dto.request.bankRequest.BankDtoRequest;
import ru.vtb.vtbbackend.web.dto.response.BankDtoResponse;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;
    public final BankOfficeRepository officeRepository;

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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");


        List<Department> newDepartments = dto.getDepartments().stream().map(
                it -> Department.builder()
                        .bankOffice(officeRepository.findByName(it.getServiceName()).orElseThrow(
                                () -> new NotFoundException("Bank office #" + it.getServiceName() + " has been found!")
                        ))
                        .workingTimes(it.getWorkingTimeDtoList().stream().map(it2 ->
                                        WorkingTime.builder()
                                                .openAt(LocalDateTime.parse(it2.getOpenAt(), formatter))
                                                .closedAt(LocalDateTime.parse(it2.getClosedAt(), formatter))
                                                .dayOfWeek(it2.getDayOfWeek().toUpperCase())
                                                .build()
                                ).toList()
                        ).build()
        ).toList();

        var bank = Bank
                .builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .coords(Coordinates.builder().
                        latitude(dto.getCoords().getLatitude()).
                        longitude(dto.getCoords().getLongitude())
                        .build()
                )
                .departments(newDepartments)
                .build();

        return new BankDtoResponse(bankRepository.save(bank));

    }
}
