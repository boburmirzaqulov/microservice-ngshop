package io.ngshop.discount;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@jakarta.persistence.Entity
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String description;
    @ManyToOne
    private DiscountProduct discountProductId;
    private Double percent;

    public Discount(String productName, String description, Double percent) {
        this.description=description;
        this.productName=productName;
        this.percent=percent;
    }
}
