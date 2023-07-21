package io.ngshop.basket.controller;
import io.ngshop.basket.dto.BasketDTO;
import io.ngshop.basket.dto.BasketV2DTO;
import io.ngshop.basket.dto.response.BasketResponse;
import io.ngshop.basket.dto.response.BasketRequest;
import io.ngshop.basket.model.Basket;
import io.ngshop.basket.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Basket")
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class BasketController {
    private final BasketService basketService;

    @GetMapping("/GetBasket/{username}")
    public ResponseEntity<BasketResponse> getBasket(@PathVariable String username) {
        return basketService.getBasketByUsername(username);
    }

    @PostMapping("/CreateBasket")
    public ResponseEntity<BasketDTO> createBasket(@RequestBody BasketDTO basketDTO) {
        return basketService.createBasket(basketDTO);

    }

    @PostMapping("/CheckoutV2")
    public ResponseEntity<Basket> checkoutBasket(@RequestBody BasketV2DTO basketV2DTO) {
        // Do checkout process
        return basketService.checkoutBasket(basketV2DTO);
    }


}
