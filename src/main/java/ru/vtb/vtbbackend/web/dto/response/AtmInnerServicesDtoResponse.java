package ru.vtb.vtbbackend.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.vtb.vtbbackend.domain.entity.AtmInnerServices;

import java.util.Objects;

@Data
public class AtmInnerServicesDtoResponse {
    @JsonProperty("wheelchair")
    private String wheelchair;
    @JsonProperty("blind")
    private String blind;
    @JsonProperty("nfcForBankCards")
    private String nfcForBankCards;
    @JsonProperty("qrRead")
    private String qrRead;
    @JsonProperty("supportsUsd")
    private String supportsUsd;
    @JsonProperty("supportsChargeRub")
    private String supportsChargeRub;
    @JsonProperty("supportsEur")
    private String supportsEur;
    @JsonProperty("supportsRub")
    private String supportsRub;

    public AtmInnerServicesDtoResponse() {
    }

    public AtmInnerServicesDtoResponse(String wheelchair, String blind, String nfcForBankCards, String qrRead, String supportsUsd, String supportsChargeRub, String supportsEur, String supportsRub) {
        this.wheelchair = wheelchair;
        this.blind = blind;
        this.nfcForBankCards = nfcForBankCards;
        this.qrRead = qrRead;
        this.supportsUsd = supportsUsd;
        this.supportsChargeRub = supportsChargeRub;
        this.supportsEur = supportsEur;
        this.supportsRub = supportsRub;
    }

    public AtmInnerServicesDtoResponse(AtmInnerServices services) {
        this.wheelchair = services.getWheelchair();
        this.blind = services.getBlind();
        this.nfcForBankCards = services.getNfcForBankCards();
        this.qrRead = services.getQrRead();
        this.supportsUsd = services.getSupportsUsd();
        this.supportsChargeRub = services.getSupportsChargeRub();
        this.supportsEur = services.getSupportsEur();
        this.supportsRub = services.getSupportsRub();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtmInnerServicesDtoResponse that = (AtmInnerServicesDtoResponse) o;
        return Objects.equals(wheelchair, that.wheelchair) && Objects.equals(blind, that.blind) && Objects.equals(nfcForBankCards, that.nfcForBankCards) && Objects.equals(qrRead, that.qrRead) && Objects.equals(supportsUsd, that.supportsUsd) && Objects.equals(supportsChargeRub, that.supportsChargeRub) && Objects.equals(supportsEur, that.supportsEur) && Objects.equals(supportsRub, that.supportsRub);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wheelchair, blind, nfcForBankCards, qrRead, supportsUsd, supportsChargeRub, supportsEur, supportsRub);
    }
}
