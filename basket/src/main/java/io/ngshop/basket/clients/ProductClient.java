package io.ngshop.basket.clients;

import io.ngshop.basket.model.Product;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://localhost:8080/Product")
@Component
public interface ProductClient {
    @RequestMapping(method = RequestMethod.GET, value = "/GetProductById/{productId}")
    Product getProductsById(@PathVariable String productId);
}
