package com.example.ordering;

import io.ngshop.ordering.dto.OrderDTO;
import io.ngshop.ordering.dto.ProductDTO;
import io.ngshop.ordering.service.OrderService;
import io.ngshop.ordering.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OrderingApplicationTests {
    @Autowired
    OrderServiceImpl orderService;

    @Test
    public void testOrderService() {
        orderService.addOrder(new OrderDTO(
                null,
                "Mirshod",
                123D,
                "Mirshod",
                "Mirjonov",
                "mirshod.mirjonov@mail.ru",
                "Yunusobod",
                "Uzb",
                "Tashkent",
                "100184",
                "123112321321312",
                "213123123123",
                "12/25",
                "123",
                List.of(new ProductDTO(
                        2,
                        "https://media.istockphoto.com/id/184276818/photo/red-apple.jpg?s=1024x1024&w=is&k=20&c=d1zu5oXbrdTrk2AtTyUtvnWLF7ZeIbTgqSXabU4ABi4=",
                        213.2,
                        "1234",
                        "Olma"
                ))
        ));
    }


}
