package io.ngshop.basket.dto.response;

import io.ngshop.basket.dto.BasketDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketRequest {
    private String username;
    BasketDTO items;
}
