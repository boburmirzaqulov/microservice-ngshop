package io.ngshop.basket.customexception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoResourceFoundException extends RuntimeException {
    private String name;
}
