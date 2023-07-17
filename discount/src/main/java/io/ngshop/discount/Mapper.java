package io.ngshop.discount;

public class Mapper {
    public static DiscountDto toDto(Discount discount){
        return new DiscountDto(
                discount.getId(),
                discount.getProductName(),
                discount.getPercent(),
                discount.getDiscountProductId().getProductId()
                        );
    }
    public  static  Discount tiEntity(DiscountCreateDto discountCreateDto){
        if(discountCreateDto==null) return null;
        return new Discount(
                discountCreateDto.getProductName(),
                discountCreateDto.getDescription(),
                discountCreateDto.getPercent()
        );
    }
}
