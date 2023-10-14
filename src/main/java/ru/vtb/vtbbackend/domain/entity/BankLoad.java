package ru.vtb.vtbbackend.domain.entity;

import jakarta.persistence.*;

@Entity
public class BankLoad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long loadFactor;

}
