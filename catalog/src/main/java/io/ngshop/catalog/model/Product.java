package io.ngshop.catalog.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    private ObjectId id;
    private String name;
    private String description;
    private Double price;
    private String summary;
    private String imageFile;
    private String brandId;
    private String typeId;
}
