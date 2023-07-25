package io.ngshop.catalog.repository;

import io.ngshop.catalog.model.Brand;
import io.ngshop.catalog.model.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends MongoRepository<Brand, ObjectId> {
    Optional<Brand> findBrandByName(String brand);
}
