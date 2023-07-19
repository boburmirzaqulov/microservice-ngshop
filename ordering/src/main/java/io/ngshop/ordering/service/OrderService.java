package io.ngshop.ordering.service;

import io.ngshop.ordering.dto.OrderDTO;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    ResponseEntity<OrderDTO> getOrderByUsername(String userName);

    ResponseEntity<OrderDTO> addOrder(OrderDTO orderDTO);

    ResponseEntity<OrderDTO> updateOrder(OrderDTO orderDTO);

    ResponseEntity<Void> deleteOrder(Long id);
}
