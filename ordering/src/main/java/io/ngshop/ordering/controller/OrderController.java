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
    @GetMapping("/v1/Order/{userName}")
    public ResponseEntity<OrderDTO> getOrderByUserName(@PathVariable String userName){
        return orderService.getOrderByUserName(userName);
    }

    @PostMapping("/v1/Order")
    public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO orderDTO){
        return orderService.addOrder(orderDTO);
    }

    @PostMapping("/v1/Order")
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO orderDTO){
        return orderService.updateOrder(orderDTO);
    }

    @DeleteMapping("/v1/Order/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
}
