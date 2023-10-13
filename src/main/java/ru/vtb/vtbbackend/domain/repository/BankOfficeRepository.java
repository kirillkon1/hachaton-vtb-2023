package ru.vtb.vtbbackend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vtb.vtbbackend.domain.entity.BankOffice;

import java.util.Optional;

public interface BankOfficeRepository extends JpaRepository<BankOffice, Long> {
    Optional<BankOffice> findByName(String name);
}