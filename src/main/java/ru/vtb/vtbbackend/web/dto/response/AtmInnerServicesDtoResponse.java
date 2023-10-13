package ru.vtb.vtbbackend.web.dto.response;

import lombok.Data;
import ru.vtb.vtbbackend.domain.entity.AtmInnerServices;

@Data
public class AtmInnerServicesDtoResponse {
    private String wheelchair;
    private String blind;
    private String nfcForBankCards;
    private String qrRead;
    private String supportsUsd;
    private String supportsChargeRub;
    private String supportsEur;
    private String supportsRub;

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
}
