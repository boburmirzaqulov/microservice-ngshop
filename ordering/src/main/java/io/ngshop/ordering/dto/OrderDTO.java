package io.ngshop.ordering.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements Serializable {
    @NotNull(message = "Id do not null!")
    @NotEmpty(message = "Id do not empty!")
    private Long id;
    @NotNull(message = "username do not null!")
    @NotEmpty(message = "Id do not empty!")
    private String username;
    @NotNull(message = "username do not null!")
    @NotEmpty(message = "username do not empty!")
    private Double totalPrice;
    @NotNull(message = "firstName do not null!")
    @NotEmpty(message = "firstName do not empty!")
    private String firstname;
    @NotNull(message = "lastname do not null!")
    @NotEmpty(message = "lastname do not empty!")
    private String lastname;
    @NotNull(message = "emailAddress do not null!")
    @NotEmpty(message = "emailAddress do not empty!")
    private String emailAddress;
    @NotNull(message = "addressline do not null!")
    @NotEmpty(message = "addressline do not empty!")
    private String addressLine;
    @NotNull(message = "country do not null!")
    @NotEmpty(message = "country do not empty!")
    private String country;
    @NotNull(message = "state do not null!")
    @NotEmpty(message = "state do not empty!")
    private String state;
    @NotNull(message = "zipcode do not null!")
    @NotEmpty(message = "zipcode do not empty!")
    private String zipCode;
    @NotNull(message = "cardName do not null!")
    @NotEmpty(message = "cardName do not empty!")
    private String cardName;
    @NotNull(message = "cardNumber do not null!")
    @NotEmpty(message = "cardNumber do not empty!")
    private String cardNumber;
    @NotNull(message = "expiration do not null!")
    @NotEmpty(message = "expiration do not empty!")
    private String expiration;
    @NotNull(message = "cvv do not null!")
    @NotEmpty(message = "cvv do not empty!")
    private String cvv;
    @NotNull(message = "items do not null!")
    @NotEmpty(message = "items do not empty!")
    private List<ProductDTO> items;

}
