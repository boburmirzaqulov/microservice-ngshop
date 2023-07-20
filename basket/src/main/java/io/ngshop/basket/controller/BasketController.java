package io.ngshop.basket.controller;
import io.ngshop.basket.dto.BasketV2DTO;
import io.ngshop.basket.dto.response.BasketResponse;
import io.ngshop.basket.dto.response.BasketRequest;
import io.ngshop.basket.model.Basket;
import io.ngshop.basket.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Basket")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @GetMapping("/GetBasket/{username}")
    public ResponseEntity<BasketResponse> getBasket(@PathVariable String username) {
        return basketService.getBasketByUsername(username);
    }

    @PostMapping("/CreateBasket")
    public ResponseEntity<BasketRequest> createBasket(@RequestBody BasketRequest basketRequest) {
        return basketService.createBasket(basketRequest);

    }

    @PostMapping("/CheckoutV2")
    public ResponseEntity<Basket> checkoutBasket(@RequestBody BasketV2DTO basketV2DTO) {
        // Do checkout process
        return basketService.checkoutBasket(basketV2DTO);
    }


}
