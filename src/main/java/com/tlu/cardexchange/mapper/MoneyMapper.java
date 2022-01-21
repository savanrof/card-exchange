package com.tlu.cardexchange.mapper;

import org.springframework.stereotype.Component;
import com.tlu.cardexchange.dto.MoneyDTO;
import com.tlu.cardexchange.entity.WithdrawMoney;

@Component
public class MoneyMapper {
  public MoneyDTO fromEntity(WithdrawMoney entity) {
    MoneyDTO dto = new MoneyDTO();
    dto.setMoney(entity.getMoney());
    return dto;
  }
}
