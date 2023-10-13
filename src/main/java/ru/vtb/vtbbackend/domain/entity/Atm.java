package ru.vtb.vtbbackend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "atms")
@Getter
@Setter
public class Atm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "address", unique = true)
    private String address;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "allDay")
    private Boolean allDay;

    @OneToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private AtmInnerServices service;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atm atm = (Atm) o;
        return Objects.equals(id, atm.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
