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
import ru.vtb.vtbbackend.web.dto.request.AtmInnerServicesDtoRequest;
import ru.vtb.vtbbackend.web.dto.response.AtmDtoPageableResponse;
import ru.vtb.vtbbackend.web.dto.response.AtmDtoResponse;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AtmService {
    private final AtmRepository atmRepository;
    private final AtmInnerServicesRepository servicesRepository;

    public List<AtmDtoResponse> getAll() {
        return atmRepository.findAll().stream().map(AtmDtoResponse::new).toList();
    }

    public AtmDtoPageableResponse getAll(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Atm> atms = atmRepository.findAll(pageRequest);
        List<AtmDtoResponse> list = atms.getContent()
                .stream()
                .map(AtmDtoResponse::new)
                .toList();
        return AtmDtoPageableResponse.builder()
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

    public AtmDtoPageableResponse getFiltered(AtmFilterDtoRequest request) {
        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getSize());
        Page<Atm> pageAtms = atmRepository.findNearestAtms(request.getUserLatitude(),request.getUserLongitude(), pageable);

        List<AtmDtoResponse> list = filter(pageAtms.getContent(), request.getServices())
                .stream()
                .map(AtmDtoResponse::new)
                .toList();

        return AtmDtoPageableResponse.builder()
                .atms(list)
                .page(Long.valueOf(request.getPage()))
                .pageSize(Long.valueOf(request.getSize()))
                .total(pageAtms.getTotalElements())
                .totalPages((long) pageAtms.getTotalPages())
                .build();
    }

    public List<Atm> filter(List<Atm> list, AtmInnerServicesDtoRequest response){
        List<Atm> atms = new ArrayList<>(list);
        for (int i = 0; i < atms.size(); i++) {
            AtmInnerServices services = list.get(i).getService();
            if(response.getBlind() && !services.getBlind().equals("AVAILABLE") ||
                    response.getWheelchair() && !services.getWheelchair().equals("AVAILABLE")||
                    response.getQrRead() && !services.getQrRead().equals("AVAILABLE")||
                    response.getNfcForBankCards() && !services.getNfcForBankCards().equals("AVAILABLE")||
                    response.getSupportsChargeRub() && !services.getSupportsChargeRub().equals("AVAILABLE")||
                    response.getSupportsUsd() && !services.getSupportsUsd().equals("AVAILABLE")||
                    response.getSupportsEur() && !services.getSupportsEur().equals("AVAILABLE")||
                    response.getSupportsRub() && !services.getSupportsRub().equals("AVAILABLE")){
                atms.remove(i);
                i--;
            }
        }
        return atms;
    }
}
