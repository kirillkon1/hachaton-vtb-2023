package ru.vtb.vtbbackend.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bank",
        uniqueConstraints = @UniqueConstraint(
                columnNames = "address")
)
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @OneToOne
    @JoinColumn(name = "coords_id", referencedColumnName = "id")
    private Coordinates coords;
    @ManyToMany
    @JoinTable(
            name = "bank_department",
            joinColumns = @JoinColumn(name = "bank_id", referencedColumnName = "id")
    )
    private List<Department> departments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(id, bank.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
