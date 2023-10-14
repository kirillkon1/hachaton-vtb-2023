package ru.vtb.vtbbackend.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vtb.vtbbackend.domain.entity.Atm;

@Repository
public interface AtmRepository extends JpaRepository<Atm, Long> {

    @Query(value = "SELECT * FROM atms a" +
            " ORDER BY 111.2 * SQRT(POWER(a.longitude - :userLongitude, 2) " +
            "+ POWER(a.latitude - :userLatitude, 2) * POWER(cos(3.141592*a.longitude/180), 2))"
    , nativeQuery = true)
    Page<Atm> findNearestAtms(
            @Param("userLatitude") double userLatitude,
            @Param("userLongitude") double userLongitude,
            Pageable pageable);
}