package io.ngshop.ordering.mapper;

import io.ngshop.ordering.dto.OrderDTO;
import io.ngshop.ordering.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderMapper {
    public OrderDTO toDTO(Order order){
        return order == null ? null : new OrderDTO(
                order.getId(),
                order.getUsername(),
                order.getTotalPrice(),
                order.getFirstname(),
                order.getLastname(),
                order.getEmailAddress(),
                order.getAddressLine(),
                order.getCountry(),
                order.getState(),
                order.getZipCode(),
                order.getCardName(),
                order.getCardNumber(),
                order.getExpiration(),
                order.getCvv(),
                order.getPaymentMethod()
        );
    }

    public Order toEntity(OrderDTO orderDTO) {
        return orderDTO == null ? null : new Order(
                orderDTO.getId(),
                orderDTO.getUserName(),
                orderDTO.getTotalPrice(),
                orderDTO.getFirstName(),
                orderDTO.getLastName(),
                orderDTO.getEmailAddress(),
                orderDTO.getAddressLine(),
                orderDTO.getCountry(),
                orderDTO.getState(),
                orderDTO.getZipCode(),
                orderDTO.getCardName(),
                orderDTO.getCardNumber(),
                orderDTO.getExpiration(),
                orderDTO.getCvv(),
                orderDTO.getPaymentMethod()

        );
    }
}

