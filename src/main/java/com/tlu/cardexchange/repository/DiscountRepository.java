package com.tlu.cardexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tlu.cardexchange.entity.Discount;

public interface DiscountRepository extends JpaRepository<DiscountRepository, Integer> {
  Discount findByHomeNetworkAndPrice(String homeNetwork, Integer price);
}
