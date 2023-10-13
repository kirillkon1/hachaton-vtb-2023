package ru.vtb.vtbbackend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vtb.vtbbackend.domain.entity.Atm;

@Repository
public interface AtmRepository extends JpaRepository<Atm, Long> {
}
