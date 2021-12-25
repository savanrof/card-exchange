package com.tlu.cardexchange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tlu.cardexchange.dto.InputCardDTO;
import com.tlu.cardexchange.entity.Discount;
import com.tlu.cardexchange.entity.HistoryInputCard;
import com.tlu.cardexchange.repository.HistoryInputCardRepository;
import com.tlu.cardexchange.service.DiscountService;
import com.tlu.cardexchange.service.HistoryInputCardService;

@Service
public class HistoryInputCardSerivceImpl implements HistoryInputCardService {

  private final HistoryInputCardRepository inputCardRepository;
  private final DiscountService discountService;

  @Autowired
  public HistoryInputCardSerivceImpl(HistoryInputCardRepository inputCardRepository, DiscountService discountService) {
    this.inputCardRepository = inputCardRepository;
    this.discountService = discountService;
  }

  @Override
  public HistoryInputCard getByTransID(String transID) {
    return inputCardRepository.findByTransID(transID);
  }

  @Override
  public boolean transIdCheck(String transID) {
    HistoryInputCard inputCard = inputCardRepository.findByTransID(transID);
    return inputCard == null;
  }

  @Override
  @Transactional
  public HistoryInputCard create(InputCardDTO dto) {
    Discount discount = discountService.findByNetworkAndPrice(dto.getHomeNetwork(), dto.getMoney());
    HistoryInputCard inputCard = new HistoryInputCard();
    inputCard.setAccount(dto.getAccount());
    inputCard.setSeri(dto.getSeri());
    inputCard.setHomeNetwork(discount);
    inputCard.setMoney(Float.parseFloat(dto.getMoney().toString()));
    inputCard.setStatus(dto.getStatus());
    inputCard.setTime(dto.getTime());
    inputCard.setTransID(dto.getTransID());
    return inputCardRepository.save(inputCard);
  }

}
