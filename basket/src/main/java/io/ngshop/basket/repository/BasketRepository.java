package io.ngshop.basket.repository;

import io.ngshop.basket.model.Basket;
import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.repository.cdi.RedisRepositoryBean;

public interface BasketRepository extends JpaRepository<Basket, Long> {

}
