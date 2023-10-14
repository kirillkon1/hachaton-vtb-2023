package ru.vtb.vtbbackend.test;


import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.*;
import ru.vtb.vtbbackend.web.dto.request.BankLoadDtoRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("api/test")
@Hidden
public class KirillsTestController {


    @PostMapping
    public Object test1(@RequestBody BankLoadDtoRequest dto){

        System.out.println(dto);

        return dto;
    }

    @GetMapping
    public String test2(){
        return "OK!";
    }

}
