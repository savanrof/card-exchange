package com.tlu.cardexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tlu.cardexchange.entity.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {
  Discount findByHomeNetworkAndPrice(String homeNetwork, Integer price);
}
