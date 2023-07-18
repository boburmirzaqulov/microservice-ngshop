package io.ngshop.basket.controller;

import io.ngshop.basket.Entity.BasketDTO;
import io.ngshop.basket.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;
    @GetMapping("/GetBasket/{userName}")
    public ResponseEntity<BasketDTO> getBasket(@PathVariable String userName){
        return basketService.getBasket(userName);
    }
    @PutMapping("/CreateBasket")
    public ResponseEntity<BasketDTO> setBasket(@RequestBody BasketDTO basketDTO){
        return basketService.setBasket(basketDTO);
    }
    @PostMapping("/CheckoutV2")
    public ResponseEntity<BasketDTO> checkoutBasket(@RequestBody BasketDTO basketDTO){
        return basketService.checkoutBasket(basketDTO);
    }
    @DeleteMapping("/DeleteBasket/{userName}")
    public void deleteBasket(@PathVariable String userName ){
        basketService.deleteBasket(userName);
    }
    @PostMapping()
    public void createBasket(@RequestBody BasketDTO basketDTO){
        basketService.createBasket(basketDTO);
    }

}
