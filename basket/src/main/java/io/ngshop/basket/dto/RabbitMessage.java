package io.ngshop.basket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RabbitMessage implements Serializable {
    private String username;
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
    private String cvv;
    private List<ProductDTO> items;
}
