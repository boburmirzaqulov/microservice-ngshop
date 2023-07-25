package io.ngshop.basket.repository;

import io.ngshop.basket.model.Basket;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface BasketRepository extends MongoRepository<Basket, ObjectId> {

    Optional<Basket> findByUserName(String username);
}
