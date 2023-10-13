package ru.vtb.vtbbackend.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vtb.vtbbackend.domain.entity.Atm;
import ru.vtb.vtbbackend.domain.repository.AtmInnerServicesRepository;
import ru.vtb.vtbbackend.domain.repository.AtmRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtmService {
    private final AtmRepository atmRepository;
    private final AtmInnerServicesRepository servicesRepository;
    public List<Atm> getAll() {
        return atmRepository.findAll();
    }
}
