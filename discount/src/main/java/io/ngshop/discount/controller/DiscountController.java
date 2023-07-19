package io.ngshop.discount.controller;

import io.ngshop.discount.dto.DiscountDto;
import io.ngshop.discount.service.DiscountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/discounts")
@Slf4j
@RequiredArgsConstructor
public class DiscountController {
    private final DiscountService discountService;

    @GetMapping("/{id}")
    public ResponseEntity<DiscountDto> getDiscountById(@PathVariable Long id){
        return discountService.getDiscountById(id);
    }


    @GetMapping
    public ResponseEntity<List<DiscountDto>> getAllDiscount(@RequestParam Optional<Integer> offset, @RequestParam Optional<Integer> limit){
        return discountService.getAllDiscount(offset,limit);
    }

    @PostMapping
    public ResponseEntity<DiscountDto> saveDiscount(@RequestBody DiscountDto discountDto){
        return discountService.saveDiscount(discountDto);
    }

    @PutMapping
    public ResponseEntity<DiscountDto> updateDiscount(@RequestBody DiscountDto discountDto){
        return discountService.updateDiscount(discountDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDiscount(@PathVariable Long id){
        discountService.deleteDiscount(id);
    }

}
