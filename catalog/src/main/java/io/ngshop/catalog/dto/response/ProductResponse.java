package io.ngshop.catalog.dto.response;

import io.ngshop.catalog.dto.ProductDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer count;
    private List<ProductDto> data;

}
