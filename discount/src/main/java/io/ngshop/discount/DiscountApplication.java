package io.ngshop.discount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class DiscountApplication  {
    public static void main(String[] args) {
        SpringApplication.run(DiscountApplication .class, args);
    }
}
