package com.tlu.cardexchange.mapper;

import org.springframework.stereotype.Component;
import com.tlu.cardexchange.dto.MoneyDTO;
import com.tlu.cardexchange.entity.Account;

@Component
public class MoneyMapper {
  public MoneyDTO fromEntity(Account entity) {
    MoneyDTO dto = new MoneyDTO();
    dto.setMoney(entity.getMoney());
    return dto;
  }
}
