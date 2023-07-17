package io.ngshop.discount.repository;

import io.ngshop.discount.entitiy.DiscountProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountProductRepository extends JpaRepository<DiscountProduct, Long> {
}
