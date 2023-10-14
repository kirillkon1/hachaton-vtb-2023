package ru.vtb.vtbbackend.web.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtmInnerServicesDtoRequest {
    @JsonProperty("wheelchair")
    private Boolean wheelchair;
    @JsonProperty("blind")
    private Boolean blind;
    @JsonProperty("nfcForBankCards")
    private Boolean nfcForBankCards;
    @JsonProperty("qrRead")
    private Boolean qrRead;
    @JsonProperty("supportsUsd")
    private Boolean supportsUsd;
    @JsonProperty("supportsChargeRub")
    private Boolean supportsChargeRub;
    @JsonProperty("supportsEur")
    private Boolean supportsEur;
    @JsonProperty("supportsRub")
    private Boolean supportsRub;
}
