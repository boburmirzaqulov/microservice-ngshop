package io.ngshop.basket.model;


import io.ngshop.basket.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Basket {
   @Id
   private ObjectId objectId;
   private String username;
   private Set<ProductDTO> items;
   private Double totalPrice;

}
