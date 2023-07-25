package io.ngshop.ordering.dto.exceptionsDTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDTO {
    private String error;
}
