package ru.vtb.vtbbackend.test;


import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("api/test")
@Hidden
public class KirillsTestController {


    @PostMapping
    public Object test1(@RequestBody TestDTO dto){

        String hour = "18:00".replace(":", "");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");

        LocalDateTime localDateTime = LocalDateTime.parse(hour, formatter);

        System.out.println(dto);

        return localDateTime;
    }

    @GetMapping
    public String test2(){
        return "OK!";
    }

}
