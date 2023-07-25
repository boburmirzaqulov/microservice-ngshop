package io.ngshop.ordering;

import io.ngshop.ordering.service.OrderService;
import io.ngshop.ordering.dto.OrderDTO;
import io.ngshop.ordering.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@Configuration
@EnableScheduling
@SpringBootApplication
public class OrderingApplication implements CommandLineRunner {
//	@Autowired
//	OrderService orderService;
	public static void main(String[] args) {
		SpringApplication.run(OrderingApplication.class, args);
	}

//	public void run(String ...args) {
//		System.out.println("beginnig adding....");
//		orderService.addOrder(new OrderDTO(
//				null,
//				"Mirshod",
//				123D,
//				"Mirshod",
//				"Mirjonov",
//				"mirshod.mirjonov@mail.ru",
//				"Yunusobod",
//				"Uzb",
//				"Tashkent",
//				"100184",
//				"123112321321312",
//				"213123123123",
//				"12/25",
//				"123",
//				List.of(new ProductDTO(
//						"GJAHGGHJK24521",
//						2,
//						"https://media.istockphoto.com/id/184276818/photo/red-apple.jpg?s=1024x1024&w=is&k=20&c=d1zu5oXbrdTrk2AtTyUtvnWLF7ZeIbTgqSXabU4ABi4=",
//						213.2,
//						"Olma"
//				))
//		));
//	}

}
