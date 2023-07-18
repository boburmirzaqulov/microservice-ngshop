package io.ngshop.ordering.service.impl;

import io.ngshop.ordering.dto.OrderDTO;
import io.ngshop.ordering.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Override
    public ResponseEntity<OrderDTO> getOrderByUserName(String userName) {
        return null;
    }

    @Override
    public ResponseEntity<OrderDTO> addOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public ResponseEntity<OrderDTO> updateOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {

    }
}
