package io.ngshop.basket.repository;

import io.ngshop.basket.model.Basket;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BasketRepository extends MongoRepository<Basket, ObjectId> {

}
