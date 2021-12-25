package com.tlu.cardexchange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tlu.cardexchange.entity.HistoryInputCard;
import com.tlu.cardexchange.repository.HistoryInputCardRepository;
import com.tlu.cardexchange.service.HistoryInputCardService;

@Service
public class HistoryInputCardSerivceImpl implements HistoryInputCardService {

  private final HistoryInputCardRepository inputCardRepository;

  @Autowired
  public HistoryInputCardSerivceImpl(HistoryInputCardRepository inputCardRepository) {
    this.inputCardRepository = inputCardRepository;
  }

  @Override
  public HistoryInputCard getByTransID(String transID) {
    return inputCardRepository.findByTransID(transID);
  }

  @Override
  public boolean transIdCheck(String transID) {
    HistoryInputCard inputCard = inputCardRepository.findByTransID(transID);
    if (inputCard != null) {
      return true;
    }
    return false;
  }

}
