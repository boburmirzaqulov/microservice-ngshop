package io.ngshop.discount;

public class Mapper {
    public static DiscountDto toDto(DiscountEntity discount){
        return new DiscountDto(
                discount.getId(),
                discount.getProductName(),
                discount.getPercent(),
                discount.getDiscountProductId().getProductId()
                        );
    }
    public  static DiscountEntity tiEntity(DiscountCreateDto discountCreateDto){
        if(discountCreateDto==null) return null;
        return new DiscountEntity(
                discountCreateDto.getProductName(),
                discountCreateDto.getDescription(),
                discountCreateDto.getPercent()
        );
    }
}
