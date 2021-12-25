package com.tlu.cardexchange.service;

import org.springframework.stereotype.Service;
import com.tlu.cardexchange.entity.Discount;

@Service
public interface DiscountService {
  Discount findByNetworkAndPrice(String network, Integer price);
}
