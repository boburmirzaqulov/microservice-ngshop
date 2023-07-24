package io.ngshop.ordering.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id

    private String Id;

    private Integer quantity;

    private String imageFile;

    private Double price;

    private String productName;
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;
}
