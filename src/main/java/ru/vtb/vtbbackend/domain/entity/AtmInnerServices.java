package ru.vtb.vtbbackend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "atm_services")
@Getter
@Setter
public class AtmInnerServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /*
        AVAILABLE - true, UNAVAILABLE - false, UNKNOWN - null
        или поменять на String
     */
    @Column(name = "wheelchair")
    private Boolean wheelchair;

    @Column(name = "blind")
    private Boolean blind;

    @Column(name = "nfcFor_bank_cards")
    private Boolean nfcForBankCards;

    @Column(name = "qr_read")
    private Boolean qrRead;

    @Column(name = "supports_usd")
    private Boolean supportsUsd;

    @Column(name = "supports_charge_rub")
    private Boolean supportsChargeRub;

    @Column(name = "supports_eur")
    private Boolean supportsEur;

    @Column(name = "supports_rub")
    private Boolean supportsRub;

    @OneToOne(mappedBy = "service")
    private Atm atm;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtmInnerServices that = (AtmInnerServices) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
