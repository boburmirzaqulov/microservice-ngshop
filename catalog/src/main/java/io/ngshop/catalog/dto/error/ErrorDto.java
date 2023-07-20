package io.ngshop.catalog.dto.error;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {
    private String message;
}
