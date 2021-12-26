package com.tlu.cardexchange.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import com.tlu.cardexchange.dto.InputCardDTO;
import com.tlu.cardexchange.entity.HistoryInputCard;

@Service
public interface HistoryInputCardService {
  HistoryInputCard getByTransID(String transID);

  boolean transIdCheck(String transID);

  HistoryInputCard create(InputCardDTO dto, HttpServletRequest request);
}
