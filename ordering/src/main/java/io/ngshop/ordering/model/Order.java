package io.ngshop.ordering.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @OneToMany(mappedBy = "order")
    private List<Product> products;


}
