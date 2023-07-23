package io.ngshop.basket.controller;
import io.ngshop.basket.dto.BasketDTO;
import io.ngshop.basket.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

    @GetMapping("/GetBasket/{username}")
    public ResponseEntity<BasketDTO> getBasket(@PathVariable String username) {
        return basketService.getBasketByUsername(username);
    }
    @PostMapping("/CreateBasket")
    public ResponseEntity<BasketDTO> createBasket(@RequestBody BasketDTO basketDTO) {
        return basketService.createBasket(basketDTO);

    }

    @PostMapping("/CheckoutV2")
    public ResponseEntity<BasketDTO> checkoutBasket(@RequestBody BasketDTO basketDto) {
        // Do checkout process
        return basketService.checkoutBasket(basketDto);
    }


}
