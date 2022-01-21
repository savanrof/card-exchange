package com.tlu.cardexchange.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import com.tlu.cardexchange.dto.MoneyDTO;

@Service
public interface MoneyService {
  MoneyDTO getMoney(HttpServletRequest request);
}
