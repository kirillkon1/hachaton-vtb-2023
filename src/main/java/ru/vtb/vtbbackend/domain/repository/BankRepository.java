package ru.vtb.vtbbackend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vtb.vtbbackend.domain.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

//    public Page<Bank>

}
