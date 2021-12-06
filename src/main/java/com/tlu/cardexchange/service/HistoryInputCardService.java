package com.tlu.cardexchange.service;

import org.springframework.stereotype.Service;
import com.tlu.cardexchange.entity.HistoryInputCard;

@Service
public interface HistoryInputCardService {
  HistoryInputCard getByTransID(String transID);
}
