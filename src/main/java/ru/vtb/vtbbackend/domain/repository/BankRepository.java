package ru.vtb.vtbbackend.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vtb.vtbbackend.domain.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {


    @Query(value = "SELECT b FROM Bank b ORDER BY SQRT(POWER(b.longitude - :userLongitude, 2) + POWER(b.latitude - :userLatitude, 2))")
    Page<Bank> findNearestBanks(
            @Param("userLatitude") double userLatitude,
            @Param("userLongitude") double userLongitude,
            Pageable pageable);

}
