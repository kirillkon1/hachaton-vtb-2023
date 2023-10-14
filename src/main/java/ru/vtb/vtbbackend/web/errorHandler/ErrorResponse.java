package ru.vtb.vtbbackend.web.errorHandler;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class ErrorResponse {
    public ErrorResponse(String message) {
        this.message = message;
        this.time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSSS"));
    }

    public ErrorResponse() {
        this.time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSSS"));
    }

    private String message = "Unexpected error";
    private String time;
}
