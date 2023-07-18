package io.ngshop.discount.repository;

import io.ngshop.discount.entitiy.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<DiscountEntity,Long> {
}
