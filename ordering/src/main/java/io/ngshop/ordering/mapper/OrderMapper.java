package io.ngshop.ordering.mapper;

import io.ngshop.ordering.dto.OrderDTO;
import io.ngshop.ordering.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderMapper {
    public Order toEntity(OrderDTO orderDTO){
        if(orderDTO == null) return  null;
        return new Order(
                orderDTO.getId(),
                orderDTO.getUserName(),
                orderDTO.getTotalPrice(),
                orderDTO.getFirstName(),
                orderDTO.getLastName(),
                orderDTO.getCardName(),
                orderDTO.getEmailAddress(),
                orderDTO.getCountry(),
                orderDTO.getState(),
                orderDTO.getAddressLine(),
                orderDTO.getZipCode(),
                orderDTO.getCardNumber(),
                orderDTO.getExpiration(),
                orderDTO.getSvv(),
                orderDTO.getPaymentMethod()
        );
    }
    public OrderDTO toDto(Order order){
        if(order == null) return  null;
        return new OrderDTO(
                order.getId(),
                order.getUsername(),
                order.getTotalPrice(),
                order.getFirstname(),
                order.getLastname(),
                order.getCardName(),
                order.getEmailAddress(),
                order.getCountry(),
                order.getState(),
                order.getAddressLine(),
                order.getZipCode(),
                order.getCardNumber(),
                order.getExpiration(),
                order.getCvv(),
                order.getPaymentMethod()
        );
    }

}
