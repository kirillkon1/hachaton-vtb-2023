package ru.vtb.vtbbackend.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vtb.vtbbackend.domain.entity.BankLoad;

import java.util.List;
import java.util.Optional;

public interface BankLoadRepository extends JpaRepository<BankLoad, Long> {


    @Query(value = "select l from BankLoad l where l.bank.id = :id ")
    Page<BankLoad> findPageLoadByBandId(@Param("id") Long bankId, Pageable pageable);

    @Query(value = "select l from BankLoad l where l.bank.id = :id ")
    List<BankLoad> findListLoadByBandId(@Param("id") Long bankId);

    @Query(value = "select l from BankLoad l where l.bank.id = :id order by l.dateTime DESC limit 1")
    Optional<BankLoad> findLastLoadByBankId(@Param("id") Long bankId);
}