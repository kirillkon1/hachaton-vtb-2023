package ru.vtb.vtbbackend.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vtb.vtbbackend.domain.repository.AtmInnerServicesRepository;
import ru.vtb.vtbbackend.domain.repository.AtmRepository;
import ru.vtb.vtbbackend.web.dto.response.AtmDtoResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtmService {
    private final AtmRepository atmRepository;
    private final AtmInnerServicesRepository servicesRepository;

    public List<AtmDtoResponse> getAll() {
        return atmRepository.findAll().stream().map(AtmDtoResponse::new).toList();
    }
}
