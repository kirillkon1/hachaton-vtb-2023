package ru.vtb.vtbbackend.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.vtb.vtbbackend.domain.entity.Atm;
import ru.vtb.vtbbackend.domain.entity.AtmInnerServices;
import ru.vtb.vtbbackend.domain.repository.AtmInnerServicesRepository;
import ru.vtb.vtbbackend.domain.repository.AtmRepository;
import ru.vtb.vtbbackend.web.dto.request.AtmDtoRequest;
import ru.vtb.vtbbackend.web.dto.request.AtmFilterDtoRequest;
import ru.vtb.vtbbackend.web.dto.response.AtmDtoPageableDto;
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

    public AtmDtoPageableDto getAll(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Atm> atms = atmRepository.findAll(pageRequest);
        List<AtmDtoResponse> list = atms.getContent()
                .stream()
                .map(AtmDtoResponse::new)
                .toList();
        return AtmDtoPageableDto.builder()
                .atms(list)
                .page(Long.valueOf(page))
                .pageSize(Long.valueOf(size))
                .total(atms.getTotalElements())
                .totalPages((long) atms.getTotalPages())
                .build();
    }

    //delete
    public void upload(AtmDtoRequest list) {
        list.getList().forEach(a -> atmRepository
                .save(new Atm(a, servicesRepository.save(new AtmInnerServices(a.getService())))
                ));
    }

    public AtmDtoPageableDto getFiltered(AtmFilterDtoRequest request) {
        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getSize());

        Page<Atm> atms = atmRepository.findNearestAtms(request.getUserLatitude(),request.getUserLongitude(), pageable);

        List<AtmDtoResponse> list = atms.getContent()
                .stream()
                .map(AtmDtoResponse::new)
                .toList();

        return AtmDtoPageableDto.builder()
                .atms(list)
                .page(Long.valueOf(request.getPage()))
                .pageSize(Long.valueOf(request.getSize()))
                .total(atms.getTotalElements())
                .totalPages((long) atms.getTotalPages())
                .build();
    }
}
