package io.ngshop.basket.controller;

import io.ngshop.basket.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Basket")
public class BasketCotroller {
    private final BasketService basketService;
    @GetMapping("/GetBasket/{username}")
    public

    @PostMapping("/CreateBasket")
    @PostMapping("/Checkout")
    @PostMapping("/Checkout")
}
