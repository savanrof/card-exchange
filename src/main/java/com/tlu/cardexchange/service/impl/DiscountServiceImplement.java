package com.tlu.cardexchange.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tlu.cardexchange.entity.Discount;
import com.tlu.cardexchange.repository.DiscountRepository;
import com.tlu.cardexchange.service.DiscountService;

@Service
@Transactional(readOnly = true)
public class DiscountServiceImplement implements DiscountService {

  private final DiscountRepository discountRepo;

  public DiscountServiceImplement(DiscountRepository discountRepo) {
    this.discountRepo = discountRepo;
  }

  @Override
  public Discount findByNetworkAndPrice(String network, Integer price) {
    return discountRepo.findByHomeNetworkAndPrice(network, price);
  }

}
