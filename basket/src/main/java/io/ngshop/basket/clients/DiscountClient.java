package io.ngshop.basket.clients;

import io.ngshop.basket.dto.DiscountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "discount-service",url = "http://localhost:8081")
@Component
public interface DiscountClient {
    @RequestMapping(method = RequestMethod.GET, value = "/Discount/{productName}")
    DiscountDTO getProductByName(@PathVariable String productName);
}
