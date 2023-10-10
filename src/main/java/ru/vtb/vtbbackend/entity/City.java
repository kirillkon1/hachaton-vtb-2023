package ru.vtb.vtbbackend.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "city",
        uniqueConstraints = @UniqueConstraint(
                columnNames = "name")
)
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
