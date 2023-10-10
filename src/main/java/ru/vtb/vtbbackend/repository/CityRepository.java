package ru.vtb.vtbbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vtb.vtbbackend.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
