package ru.vtb.vtbbackend.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Coordinates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "y_pos")
    private Double latitude;
    @Column(name = "x_pos")
    private Double longitude;
    @OneToOne(mappedBy = "coords")
    private Bank bank;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
