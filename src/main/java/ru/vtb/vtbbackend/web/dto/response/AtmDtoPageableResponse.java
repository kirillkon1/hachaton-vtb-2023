package ru.vtb.vtbbackend.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AtmDtoPageableResponse {
    private List<AtmDtoResponse> atms;

    @JsonProperty("page")
    private Long page;

    @JsonProperty("page_size")
    private Long pageSize;

    @JsonProperty("total")
    private Long total;
    @JsonProperty("total_pages")
    private Long totalPages;
}
