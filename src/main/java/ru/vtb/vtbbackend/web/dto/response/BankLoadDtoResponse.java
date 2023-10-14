package ru.vtb.vtbbackend.web.dto.response;

import lombok.Data;
import ru.vtb.vtbbackend.domain.entity.BankLoad;

import java.time.format.DateTimeFormatter;

@Data
public class BankLoadDtoResponse {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSSS");

    public BankLoadDtoResponse(BankLoad load){
        this.load = load.getLoad();
        this.time = load.getDateTime().format(formatter);
    }

    private String time;
    private Double load;


}
