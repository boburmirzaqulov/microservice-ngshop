package io.ngshoop.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String address;
    private String country;
    private String state;
    private String zipCode;
    private String cardName;
    private String cardNumber;
    private String expiration;
    private String cvv;
}
