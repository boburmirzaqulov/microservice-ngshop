package io.ngshop.catalog.repository;

import io.ngshop.catalog.model.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId>, QuerydslPredicateExecutor<Product> {
    List<Product> findByName(String name);
}
