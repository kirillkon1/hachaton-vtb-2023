package ru.vtb.vtbbackend.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vtb.vtbbackend.domain.entity.Bank;

import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {


    @Query(value = "SELECT DISTINCT b.*, SQRT(POWER(b.longitude - :userLongitude, 2) + POWER(b.latitude - :userLatitude, 2)) as distance " +
            "FROM Bank b " +
            "JOIN bank_department bd ON b.id = bd.bank_id " +
            "JOIN department d ON d.id = bd.departments_id " +
            "JOIN service_of_bank sob ON d.office_id = sob.id " +
            "WHERE sob.name IN (:departments) " +
            "ORDER BY distance",
            nativeQuery = true)
    Page<Bank> findNearestBanks(
            @Param("userLongitude") double userLongitude,
            @Param("userLatitude") double userLatitude,
            @Param("departments") List<String> departments,
            Pageable pageable);



    @Query(value = "SELECT DISTINCT b.*, SQRT(POWER(b.longitude - :userLongitude, 2) + POWER(b.latitude - :userLatitude, 2)) as distance " +
            "FROM Bank b " +
            "JOIN bank_department bd ON b.id = bd.bank_id " +
            "JOIN department d ON d.id = bd.departments_id " +
            "JOIN service_of_bank sob ON d.office_id = sob.id " +
            "WHERE sob.name IN (:departments) and b.has_ramp = true " +
            "ORDER BY distance",
            nativeQuery = true)
    Page<Bank> findNearestBanksWithRamp(
            @Param("userLongitude") double userLongitude,
            @Param("userLatitude") double userLatitude,
            @Param("departments") List<String> departments,
            Pageable pageable);


    @Query(value = "SELECT DISTINCT * FROM (SELECT b.* FROM Bank b LEFT JOIN bank_department bd ON b.id = bd.bank_id LEFT JOIN department d ON d.id = bd.departments_id LEFT JOIN service_of_bank s ON s.id = d.office_id WHERE b.has_ramp = true AND s.name IN(:departments) ORDER BY SQRT(POWER(b.longitude - :userLongitude, 2) + POWER(b.latitude - :userLatitude, 2)))",
            nativeQuery = true)
    Page<Bank> findNearestBanksFiltered(
            @Param("userLatitude") double userLatitude,
            @Param("userLongitude") double userLongitude,
            @Param("departments") List<String> departments,
            Pageable pageable);

    @Query(value = "SELECT DISTINCT * FROM (SELECT b.* FROM Bank b" +
            " LEFT JOIN bank_department bd ON b.id = bd.bank_id " +
            " LEFT JOIN department d ON d.id = bd.departments_id" +
            " LEFT JOIN service_of_bank s ON s.id = d.office_id" +
            " WHERE s.name IN(:departments)" +
            " ORDER BY SQRT(POWER(b.longitude - :userLongitude, 2) + POWER(b.latitude - :userLatitude, 2)))",
            nativeQuery = true)
    Page<Bank> findNearestBanksFilteredWithoutRamp(
            @Param("userLatitude") double userLatitude,
            @Param("userLongitude") double userLongitude,
            @Param("departments") List<String> departments,
            Pageable pageable);

}
