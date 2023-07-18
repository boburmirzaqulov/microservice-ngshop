package io.ngshop.discount;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@RequestMapping("/discount")
@RequiredArgsConstructor
public class DiscountController {
    private final Service service;
    @GetMapping("{productId}")
    public ResponseEntity<DiscountDto> getByProductId(@PathVariable Long productId){
        return service.getByProductId(productId);
    }
    @GetMapping("{slug}")
    public ResponseEntity<DiscountDto> getDiscount(@PathVariable String slug){
        return service.getDiscount(slug);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createDiscount(@RequestBody DiscountCreateDto discountCreateDto){
        return service.createDiscount(discountCreateDto);
    }
    @PutMapping("/{slug}")
    public  ResponseEntity<DiscountDto> updateDiscount(@PathVariable String slug, @RequestBody DiscountDto discountDto){
        return service.updateDiscount(slug,discountDto);
    }
    @DeleteMapping("/{slug}")
    public ResponseEntity<String> deleteDiscount(@PathVariable String slug ){
        return service.deleteDiscount(slug);
    }

}
