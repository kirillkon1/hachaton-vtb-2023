package ru.vtb.vtbbackend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "service_of_bank", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class ServiceOfBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceOfBank that = (ServiceOfBank) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
