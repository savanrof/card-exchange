package com.tlu.cardexchange.service.impl;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tlu.cardexchange.entity.HistoryInputCard;
import com.tlu.cardexchange.repository.HistoryInputCardRepository;
import com.tlu.cardexchange.service.AccountService;
import com.tlu.cardexchange.service.CallBackService;
import com.tlu.cardexchange.service.HistoryInputCardService;
import com.tlu.cardexchange.util.ErrorCodeUtil;

@Service
@Transactional(readOnly = true)
public class CallBackServiceImpl implements CallBackService {

  private static final Integer SUCESS_99 = 99;
  private static final Integer SUCESS_N99 = -99;

  private final HistoryInputCardService inputCardService;
  private final HistoryInputCardRepository inputCardRepository;
  private final AccountService accountService;
  private final ErrorCodeUtil codeUtil;

  @Autowired
  public CallBackServiceImpl(HistoryInputCardService inputCardService, HistoryInputCardRepository inputCardRepository, AccountService accountService, ErrorCodeUtil codeUtil) {
    this.inputCardService = inputCardService;
    this.inputCardRepository = inputCardRepository;
    this.accountService = accountService;
    this.codeUtil = codeUtil;
  }

  @Override
  @Transactional
  public void callBackResult(Integer errorCode, String data, String transID, String msg, String sign) {
    HistoryInputCard inputCard = inputCardService.getByTransID(transID);
    inputCard.setStatus(codeUtil.getMessageFromCode(errorCode));

    BigDecimal moneyAfterDiscount = calculateMoneyRecive(getCardValue(data), inputCard.getHomeNetwork().getDiscount());

    if (successCodeCheck(errorCode)) {
      accountService.updateMoney(moneyAfterDiscount, inputCard.getAccount().getUsername());
    } else if (wrongCardValueCheck(errorCode)) {
      accountService.updateMoney(moneyAfterDiscount.divide(BigDecimal.valueOf(2)), "admin");
    }
    inputCardRepository.save(inputCard);
  }

  @Override
  public boolean successCodeCheck(Integer errorCode) {
    return SUCESS_99.equals(errorCode) || SUCESS_N99.equals(errorCode);
  }

  @Override
  public Double getCardValue(String data) {
    String[] dataArray = data.split("\\|");
    return Double.valueOf(dataArray[1]);
  }

  @Override
  public BigDecimal calculateMoneyRecive(Double current, Double discount) {
    return BigDecimal.valueOf(current).multiply(BigDecimal.valueOf(discount));
  }

  @Override
  public boolean wrongCardValueCheck(Integer errorCode) {
    return errorCode.equals(2);
  }

}
