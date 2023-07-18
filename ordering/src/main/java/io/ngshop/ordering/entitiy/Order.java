package io.ngshop.ordering.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private Double totalPrice;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String addressLine;
    private String country;
    private String state;
    private String zipCode;
    private String cardName;
    private String cardNumber;
    private String expiration;
    private String svv;
    private Integer paymentMethod;

}
