package io.ngshop.ordering.service.impl;



import io.ngshop.ordering.dto.OrderDTO;
import io.ngshop.ordering.exception.NotFoundException;
import io.ngshop.ordering.mapper.OrderMapper;
import io.ngshop.ordering.model.Order;
import io.ngshop.ordering.model.Product;
import io.ngshop.ordering.repository.OrderRepository;
import io.ngshop.ordering.repository.ProductRepository;
import io.ngshop.ordering.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductRepository productRepository;
    public ResponseEntity<OrderDTO> getOrderByUsername(String username) {
        Order order = orderRepository.findByUsername(username).orElseThrow(
                () -> new NotFoundException("order not found"));

        return ResponseEntity.ok(orderMapper.toDTO(order));
    }


    @Override
    public ResponseEntity<OrderDTO> addOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        if (order == null){
            throw new NotFoundException("order not found");
        }
        order.setId(null);
        productRepository.saveAll(order.getProducts());
        Order save = orderRepository.save(order);
        return ResponseEntity.ok(orderMapper.toDTO(save));
    }

    @Override
    public ResponseEntity<OrderDTO> updateOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        if (order == null){
            throw new NotFoundException("order not found");
        }
        Order byUsername = orderRepository.findByUsername(order.getUsername()).orElseThrow(
                () -> new NotFoundException("order not found")
        );

        byUsername.setTotalPrice(order.getTotalPrice());
        byUsername.setFirstname(order.getFirstname());
        byUsername.setLastname(order.getLastname());
        byUsername.setEmailAddress(order.getEmailAddress());

        byUsername.setAddressLine(order.getAddressLine());
        byUsername.setCountry(order.getCountry());
        byUsername.setState(order.getState());
        byUsername.setZipCode(order.getZipCode());
        byUsername.setCardName(order.getCardName());
        byUsername.setCardNumber(order.getCardNumber());
        byUsername.setExpiration(order.getExpiration());
        byUsername.setCvv(order.getCvv());
        byUsername.setProducts(productRepository.saveAll(order.getProducts()));
        return ResponseEntity.ok(orderMapper.toDTO(byUsername));
    }

    @Override
    public ResponseEntity<Void> deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new NotFoundException("order not found")
        );
        orderRepository.delete(order);
        return (ResponseEntity<Void>) ResponseEntity.ok();
    }
}
