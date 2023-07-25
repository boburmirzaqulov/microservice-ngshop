package io.ngshop.basket.controller;
import io.ngshop.basket.dto.response.BasketResponse;
import io.ngshop.basket.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Basket")
@CrossOrigin(origins = "*")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @GetMapping("/GetBasket/{username}")
    public ResponseEntity<BasketResponse> getBasket(@PathVariable String username) {
        return basketService.getBasketByUsername(username);
    }


    @PostMapping("/CreateBasket")
    public ResponseEntity<BasketResponse> createBasket(@RequestBody BasketResponse basketResponse) {
        return basketService.createBasket(basketResponse);

    }

    @DeleteMapping("/DeleteBasket{username}")
    public ResponseEntity<Void> deleteBasket(@PathVariable String username){
        return basketService.deleteBasket(username);
    }

    @PostMapping("/CheckoutV2")
    public ResponseEntity<BasketResponse> checkoutBasket(@RequestBody BasketResponse basketResponse) {
        // Do checkout process
        return basketService.checkoutBasket(basketResponse);
    }


}
