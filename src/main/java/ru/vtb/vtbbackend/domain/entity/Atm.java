package ru.vtb.vtbbackend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vtb.vtbbackend.web.dto.response.AtmDtoResponse;
import ru.vtb.vtbbackend.web.dto.response.AtmInnerServicesDtoResponse;

import java.util.Objects;

@Entity
@Table(name = "atms")
@Getter
@Setter
@NoArgsConstructor
public class Atm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "address")
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

    public Atm(AtmDtoResponse atm, AtmInnerServices service) {
        this.address = atm.getAddress();
        this.latitude = atm.getLatitude();
        this.longitude = atm.getLongitude();
        this.allDay = atm.getAllDay();
        this.service = service;
    }

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
