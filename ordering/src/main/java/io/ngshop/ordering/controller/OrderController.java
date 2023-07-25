package io.ngshop.ordering.controller;

import io.ngshop.ordering.dto.OrderDTO;
import io.ngshop.ordering.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Order")
@Slf4j
@RequiredArgsConstructor

public class OrderController {
    private final OrderService orderService;
    @GetMapping("/{username}")
    public ResponseEntity<OrderDTO> getOrderByUsername(@PathVariable String username){
        return orderService.getOrderByUsername(username);
    }

    @PutMapping("/Order")
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO orderDTO){
        return orderService.updateOrder(orderDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id){
        return orderService.deleteOrder(id);
    }
}
