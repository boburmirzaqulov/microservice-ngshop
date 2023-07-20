package io.ngshop.discount.customexeption;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoResourceFoundException  extends RuntimeException{
    private String message;
}
