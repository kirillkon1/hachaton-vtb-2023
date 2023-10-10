package ru.vtb.vtbbackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class VtbBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(VtbBackendApplication.class, args);
    }

}
