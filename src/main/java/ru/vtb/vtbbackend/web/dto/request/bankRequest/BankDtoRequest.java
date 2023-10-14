package ru.vtb.vtbbackend.web.dto.request.bankRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;


import java.util.List;

@Getter
@ToString
@Schema(description = "DTO-ответ о банке")
public class BankDtoRequest {

    @NotBlank
    @Schema(name = "Имя банка", example = "ДО «ТЕСТОВЫЙ» Филиала № 0000 Банка ВТБ (ПАО)")
    private String name;

    @NotBlank
    @Schema(name = "Адрес банка", example = "141506, Тестовая область, г. Тестоград, ул. Проверочная, д. 404")
    private String address;

    @Schema(name = "Широта", example = "56.11111")
    private Double latitude;

    @Schema(name = "Долгота", example = "56.11111")
    private Double longitude;

    @JsonProperty("phone_number")
    @Schema(name = "Номер телефона", example = "+7 900 000 00 00")
    private String phoneNumber;

    @Schema(name = "Рейтинг банка", description = "Рейтинг от 0 до 5", example = "4.98")
    private Double rating;

    @Schema(name = "Статус работы")
    private boolean status;

    @Schema(name = "Наличе РКО")
    private boolean rko;

    @JsonProperty("has_ramp")
    @Schema(name = "Наличе пандуса")
    private boolean hasRamp;

    @JsonProperty("sale_point_format")
    private String salePointFormat;

    @Schema(name = "Загрузка банка", description = "Значения от 0.0 до 1.0")
    private Double load;

    private List<DepartmentDtoRequest> departments;

    @JsonProperty("json_info")
    @Schema(name = "Дополнительная информация в формате JSON")
    private String jsonInfo;

}
