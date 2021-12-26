package com.tlu.cardexchange.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.tlu.cardexchange.entity.Account;

@Service
public interface AccountService {
  Account findByUsername(String username);

  Account updateMoney(BigDecimal value, String username);

  Account createUser(Account payload);
}
