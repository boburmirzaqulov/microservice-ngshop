package io.ngshop.discount.CouponDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponDto {
    private Long id;
    private String ProductName;
    private Double Amount;
    private String Description;
}
//
//    private Long id;
//    private String ProductName;
//    private Double Amount;
//    private String Description;
