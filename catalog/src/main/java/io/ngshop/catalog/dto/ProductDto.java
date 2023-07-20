package io.ngshop.catalog.dto;

import lombok.*;
import org.bson.types.ObjectId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private String id;
    private String name;
    private String description;
    private Double price;
    private String summary;
    private String imageFile;
    private String brandId;
    private String typeId;
}
