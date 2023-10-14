package ru.vtb.vtbbackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class })
public class VtbBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(VtbBackendApplication.class, args);
    }

}
