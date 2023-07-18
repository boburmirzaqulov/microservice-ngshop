package io.ngshop.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
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
    private ObjectId typeId;
    private ObjectId brandId;
}
