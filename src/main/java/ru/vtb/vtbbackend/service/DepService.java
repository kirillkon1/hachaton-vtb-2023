package ru.vtb.vtbbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vtb.vtbbackend.dto.DepartmentDto;
import ru.vtb.vtbbackend.mapper.DepMapper;
import ru.vtb.vtbbackend.repository.DepRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DepService {
    private final DepRepository depRepository;

    public List<DepartmentDto> getAllDepartments() {
        return depRepository.findAll()
                .stream()
                .map(DepMapper.INSTANCE::departmentToDepartmentDto)
                .toList();
    }
}
