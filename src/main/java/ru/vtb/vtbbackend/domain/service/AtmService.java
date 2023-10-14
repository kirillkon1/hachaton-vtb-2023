package ru.vtb.vtbbackend.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.vtb.vtbbackend.domain.entity.Atm;
import ru.vtb.vtbbackend.domain.entity.AtmInnerServices;
import ru.vtb.vtbbackend.domain.repository.AtmInnerServicesRepository;
import ru.vtb.vtbbackend.domain.repository.AtmRepository;
import ru.vtb.vtbbackend.web.dto.request.AtmDtoRequest;
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

    public List<AtmDtoResponse> getAll(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return atmRepository.findAll(pageRequest)
                .getContent()
                .stream()
                .map(AtmDtoResponse::new)
                .toList();
    }

    //delete
    public void upload(AtmDtoRequest list) {
        List<AtmDtoResponse> list1 = list.getList();

        list1.forEach(a -> atmRepository
                .save(new Atm(a, servicesRepository.save(new AtmInnerServices(a.getService())))
                ));
    }
}
