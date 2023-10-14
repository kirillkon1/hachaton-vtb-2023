package ru.vtb.vtbbackend.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Builder
@Data
public class BankDtoPageable {

    private List<BankDtoResponse> banks;

    @JsonProperty("page")
    private Long page;

    @JsonProperty("page_size")
    private Long pageSize;

    @JsonProperty("total")
    private Long total;
    @JsonProperty("total_pages")
    private Long totalPages;

}
