package ru.vtb.vtbbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vtb.vtbbackend.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
