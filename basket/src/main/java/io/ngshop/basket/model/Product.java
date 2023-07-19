package io.ngshop.basket.model;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private ObjectId id;
    private String name;
    private String description;
    private Double price;
    private String summary;
    private String imageFile;
    private ObjectId brandId;
}
