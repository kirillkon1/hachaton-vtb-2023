package ru.vtb.vtbbackend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vtb.vtbbackend.domain.entity.ServiceOfBank;

import java.util.Optional;

public interface ServiceOfBankRepository extends JpaRepository<ServiceOfBank, Long> {
    Optional<ServiceOfBank> findByName(String name);
}