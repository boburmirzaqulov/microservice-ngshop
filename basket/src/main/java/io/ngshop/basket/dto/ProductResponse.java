package io.ngshop.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer count;
    private List<ProductDto> data;
}
