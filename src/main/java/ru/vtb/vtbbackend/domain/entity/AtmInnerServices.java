package ru.vtb.vtbbackend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.vtb.vtbbackend.web.dto.response.AtmInnerServicesDtoResponse;

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

    @Column(name = "wheelchair")
    private String wheelchair;

    @Column(name = "blind")
    private String blind;

    @Column(name = "nfcFor_bank_cards")
    private String nfcForBankCards;

    @Column(name = "qr_read")
    private String qrRead;

    @Column(name = "supports_usd")
    private String supportsUsd;

    @Column(name = "supports_charge_rub")
    private String supportsChargeRub;

    @Column(name = "supports_eur")
    private String supportsEur;

    @Column(name = "supports_rub")
    private String supportsRub;

    @OneToOne(mappedBy = "service")
    private Atm atm;

    //delete
    public AtmInnerServices(AtmInnerServicesDtoResponse dto) {
        this.wheelchair = dto.getWheelchair();
        this.blind = dto.getBlind();
        this.nfcForBankCards = dto.getNfcForBankCards();
        this.qrRead = dto.getQrRead();
        this.supportsUsd = dto.getSupportsUsd();
        this.supportsChargeRub = dto.getSupportsChargeRub();
        this.supportsEur = dto.getSupportsEur();
        this.supportsRub = dto.getSupportsRub();
    }

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
