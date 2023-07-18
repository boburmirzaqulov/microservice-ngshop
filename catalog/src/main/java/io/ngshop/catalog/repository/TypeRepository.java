package io.ngshop.catalog.repository;

import io.ngshop.catalog.model.Type;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypeRepository extends MongoRepository<Type, ObjectId> {
}
