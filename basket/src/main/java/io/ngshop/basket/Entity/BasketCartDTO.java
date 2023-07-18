package io.ngshop.basket.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BasketCartDTO {
    private String UserName;
    private List<BasketDTO> Items;
}
