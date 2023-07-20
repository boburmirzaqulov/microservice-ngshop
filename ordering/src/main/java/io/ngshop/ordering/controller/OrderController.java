package io.ngshop.ordering.controller;

import io.ngshop.ordering.dto.OrderDTO;
import io.ngshop.ordering.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @GetMapping("/Order/{username}")
    public ResponseEntity<OrderDTO> getOrderByUsername(@PathVariable String username){
        return orderService.getOrderByUsername(username);
    }

    @PostMapping("/Order")
    public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO orderDTO){
        return orderService.addOrder(orderDTO);
    }

    @PutMapping("/Order")
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO orderDTO){
        return orderService.updateOrder(orderDTO);
    }

    @DeleteMapping("/Order/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
}
