package io.ngshop.ordering.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private Double totalPrice;
    private String firstname;
    private String lastname;
    private String emailAddress;
    private String addressLine;
    private String country;
    private String state;
    private String zipCode;
    private String cardName;
    private String cardNumber;
    private String expiration;
    private String cvv;
    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;


}
