package ru.vtb.vtbbackend.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vtb.vtbbackend.domain.repository.DepRepository;
import ru.vtb.vtbbackend.web.dto.response.DepartmentDtoResponse;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartamentService {
    private final DepRepository depRepository;

    public List<DepartmentDtoResponse> getAllDepartments() {
        return depRepository.findAll().stream().map(DepartmentDtoResponse::new).toList();
    }
}
