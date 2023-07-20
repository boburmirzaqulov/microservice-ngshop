package io.ngshop.ordering.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String username;
    public Double totalPrice;
    public String firstname;
    public String lastname;
    public String emailAddress;
    public String addressLine;
    public String country;
    public String state;
    public String zipCode;
    public String cardName;
    public String cardNumber;
        public String expiration;
    public String cvv;
    public Integer paymentMethod;
}
