package io.ngshop.catalog.dto.exceptionsDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDto {
    private String error;
}
