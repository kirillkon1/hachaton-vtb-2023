package ru.vtb.vtbbackend.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bank")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Column(name = "address")
    private String address;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column
    private boolean status;

    @Column(name = "rko")
    private boolean rko;

    @Column(name = "sale_point_format")
    private String salePointFormat;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "metro_id")
    private MetroStation metroStation;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "has_ramp")
    private boolean hasRamp;

    @ManyToMany(cascade = CascadeType.ALL)
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
