package com.tlu.cardexchange.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public interface CallBackService {
  boolean successCodeCheck(Integer errorCode);

  boolean wrongCardValueCheck(Integer errorCode);

  void callBackResult(Integer errorCode, String data, String transID, String msg, String sign);

  Double getCardValue(String data);

  BigDecimal calculateMoneyRecive(Double current, Double discount);
}
