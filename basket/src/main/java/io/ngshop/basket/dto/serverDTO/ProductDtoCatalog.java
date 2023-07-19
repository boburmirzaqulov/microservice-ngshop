package io.ngshop.basket.dto.serverDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDtoCatalog {
    private ObjectId id;
    private String name;
    private String description;
    private Double price;
    private String summary;
    private String imageFile;
    private ObjectId brandId;
}
