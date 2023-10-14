package ru.vtb.vtbbackend.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import ru.vtb.vtbbackend.domain.entity.BankLoad;

import java.util.List;

@Data
@Builder
public class BankLoadPageableDtoResponse {

    BankDtoResponse bank;

    List<BankLoad> loads;

    @JsonProperty("page")
    private Long page;

    @JsonProperty("page_size")
    private Long pageSize;

    @JsonProperty("total")
    private Long total;
    @JsonProperty("total_pages")
    private Long totalPages;
}
