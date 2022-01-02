package com.tlu.cardexchange.mapper;

import org.springframework.stereotype.Component;
import com.tlu.cardexchange.dto.HistoryCardDTO;
import com.tlu.cardexchange.entity.HistoryInputCard;

@Component
public class InputCardMapper {
  public HistoryCardDTO fromEntity(HistoryInputCard entity) {
    HistoryCardDTO dto = new HistoryCardDTO();
    dto.setSeri(entity.getSeri());
    dto.setMoney(entity.getMoney());
    dto.setHomeNetwork(entity.getHomeNetwork().getHomeNetwork());
    dto.setStatus(entity.getStatus());
    dto.setTime(entity.getTime());
    return dto;
  }
}
