package ru.vtb.vtbbackend.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.vtb.vtbbackend.domain.entity.Bank;
import ru.vtb.vtbbackend.domain.entity.Department;
import ru.vtb.vtbbackend.domain.entity.OpenHours;
import ru.vtb.vtbbackend.domain.entity.ServiceOfBank;
import ru.vtb.vtbbackend.domain.repository.BankLoadRepository;
import ru.vtb.vtbbackend.domain.repository.ServiceOfBankRepository;
import ru.vtb.vtbbackend.domain.repository.BankRepository;
import ru.vtb.vtbbackend.exceptions.BankNotFoundException;
import ru.vtb.vtbbackend.exceptions.CustomNotFoundException;
import ru.vtb.vtbbackend.web.dto.request.BankFilterDtoRequest;
import ru.vtb.vtbbackend.web.dto.request.bankRequest.BankDtoRequest;
import ru.vtb.vtbbackend.web.dto.response.BankDtoPageableResponse;
import ru.vtb.vtbbackend.web.dto.response.BankDtoResponse;
import ru.vtb.vtbbackend.web.dto.response.BankLoadDtoPageableResponse;
import ru.vtb.vtbbackend.web.dto.response.BankLoadDtoResponse;


import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankService {

    private final BankRepository bankRepository;
    private final ServiceOfBankRepository serviceRepository;
    private final BankLoadRepository loadRepository;

    public BankDtoResponse getBank(Long id) throws BankNotFoundException {
        var bank = bankRepository.findById(id).orElseThrow(() -> new BankNotFoundException("Bank hasn't been found with id: " + id));
        return mapBankToDto(bank);

    }

    public List<BankDtoResponse> getAllBanks() {
        return bankRepository.findAll().stream().map(BankDtoResponse::new).toList();
    }

    public BankDtoPageableResponse getBankByPagination(Integer size, Integer page) {
        Pageable pageable = PageRequest.of(page, size);

        log.info(pageable.toString());
        var banks = bankRepository.findAll(pageable);
        var bankDtos = banks.stream().map(this::mapBankToDto).toList();

        return BankDtoPageableResponse.builder()
                .banks(bankDtos)
                .page(Long.valueOf(page))
                .pageSize(Long.valueOf(size))
                .total(banks.getTotalElements())
                .totalPages((long) banks.getTotalPages())
                .build();


    }


    public BankDtoPageableResponse filter(BankFilterDtoRequest filterDto) {
        Pageable pageable = PageRequest.of(filterDto.getPage(), filterDto.getSize());


        var banks = bankRepository.findNearestBanks(filterDto.getUserX(), filterDto.getUserY(), pageable);
        var bankDtos = banks.stream().map(this::mapBankToDto).toList();

        return BankDtoPageableResponse.builder()
                .banks(bankDtos)
                .page(Long.valueOf(filterDto.getPage()))
                .pageSize(Long.valueOf(filterDto.getSize()))
                .total(banks.getTotalElements())
                .totalPages((long) banks.getTotalPages())
                .build();

    }

    public BankDtoPageableResponse filter2(BankFilterDtoRequest filterDto) {
        Pageable pageable = PageRequest.of(filterDto.getPage(), filterDto.getSize());

        Page<Bank> banks;
        if(filterDto.isHasRamp()){
            banks = bankRepository.findNearestBanksFiltered(filterDto.getUserX(), filterDto.getUserY(),
                    filterDto.getDepartments(), pageable);
        }else{
            banks = bankRepository.findNearestBanksFilteredWithoutRamp(filterDto.getUserX(), filterDto.getUserY(),
                    filterDto.getDepartments(), pageable);
        }

        var bankDtos = banks.stream().map(BankDtoResponse::new).toList();
        return BankDtoPageableResponse.builder()
                .banks(bankDtos)
                .page(Long.valueOf(filterDto.getPage()))
                .pageSize(Long.valueOf(filterDto.getSize()))
                .total(banks.getTotalElements())
                .totalPages((long) banks.getTotalPages())
                .build();


    }

    public BankLoadDtoPageableResponse getBankLoad(Long bankId, Integer page, Integer size) throws CustomNotFoundException {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date_time"));
        var bank = bankRepository.findById(bankId).orElseThrow(
                () -> new CustomNotFoundException("Bank with id #" + bankId + "hasn't been found!"));

//        var loads = loadRepository.findPageLoadByBandId(bankId, pageable);

        var loads = loadRepository.findListLoadByBandId(bankId).stream().map(BankLoadDtoResponse::new).toList();
//        return BankLoadDtoPageableResponse.builder()
//                .loads(loads.toList())
//                .bank(new BankDtoResponse(bank))
//                .page(Long.valueOf(page))
//                .pageSize(Long.valueOf(size))
//                .total(loads.getTotalElements())
//                .totalPages((long) loads.getTotalPages())
//                .build();

        return BankLoadDtoPageableResponse.builder()
                .bank(mapBankToDto(bank))
                .loads(loads)
                .build();
    }

    public BankDtoResponse create(BankDtoRequest dto) {

//        List<Department> newDepartments = dto.getDepartments().stream().map(
//                it -> {
//                    Department.builder()
//                            .serviceOfBank(serviceRepository.findByName(it.getServiceOfBank())
//                                    .orElseGet(() -> {
//                                        var serviceOfBank = new ServiceOfBank();
//                                        serviceOfBank.setName(it.getServiceOfBank());
//                                        return serviceRepository.save(serviceOfBank);
//                                    }
//                            ))
//                            .openHours((
//                                    it.getOpenHoursList().stream().map(it2 ->
//                                            OpenHours.builder()
//                                                    .openAt(it2.getOpenAt())
//                                                    .closedAt(it2.getClosedAt())
//                                                    .dayOfWeek(it2.getDayOfWeek().toUpperCase())
//                                                    .build()
//                                    ).toList()
//                            ))
//                            .build();
//                }
//        ).toList();

        List<Department> departments =
                dto.getDepartments().stream().map(
                        it -> Department.builder()
                        .serviceOfBank(
                                serviceRepository.findByName(it.getServiceOfBank())
                                        .orElseGet(() -> {
                                            var serviceOfBank = new ServiceOfBank();
                                            serviceOfBank.setName(it.getServiceOfBank());
                                            return serviceRepository.save(serviceOfBank);
                                        })
                        )
                        .openHours(
                                it.getOpenHoursList().stream().map(
                                        it2 -> OpenHours.builder()
                                                .openAt(it2.getOpenAt())
                                                .closedAt(it2.getClosedAt())
                                                .dayOfWeek(it2.getDayOfWeek().toUpperCase())
                                                .build()
                                ).toList()
                        )
                        .build()
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
                .departments(departments)
                .build();

        System.out.println(bank);

        var newBank = bankRepository.save(bank);
        return new BankDtoResponse(newBank);

    }

    private BankDtoResponse mapBankToDto(Bank bank) {
        var dto = new BankDtoResponse(bank);
        var load = loadRepository.findLastLoadByBankId(bank.getId());

        if (load.isPresent()) {
            dto.setLoad(new BankLoadDtoResponse(load.get()));
        } else {
            dto.setLoad(null);
        }

        return dto;
    }

    private void generateServiceOfBank() {
        String name1 = "openHoursIndividual";
        String name2 = "openHours";
    }

    public void deleteAll() {
        bankRepository.deleteAll();
    }

}
