package io.ngshop.basket.clients;

import io.ngshop.basket.dto.DiscountDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "discount-service",url = "http://localhost:8082")
public interface DiscountClient {
    @RequestMapping(method = RequestMethod.GET, value = "/Discount/{productName}")
    DiscountDTO getDiscount(@PathVariable String productName);
}
