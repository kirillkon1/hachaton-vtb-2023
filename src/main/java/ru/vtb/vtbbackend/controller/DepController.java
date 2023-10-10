package ru.vtb.vtbbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vtb.vtbbackend.dto.DepartmentDto;
import ru.vtb.vtbbackend.service.DepService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepController {
    private final DepService depService;

    @GetMapping("/get-all")
    ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        return ResponseEntity.ok(depService.getAllDepartments());
    }
}
