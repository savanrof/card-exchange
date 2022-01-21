package com.tlu.cardexchange.service.impl;

import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tlu.cardexchange.dto.MoneyDTO;
import com.tlu.cardexchange.entity.Account;
import com.tlu.cardexchange.mapper.AccountMapper;
import com.tlu.cardexchange.mapper.MoneyMapper;
import com.tlu.cardexchange.repository.AccountRepository;
import com.tlu.cardexchange.service.AccountService;
import com.tlu.cardexchange.util.JwtUtil;

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

  private final AccountMapper mapper;
  private final MoneyMapper moneyMapper;
  private final AccountRepository accountRepository;
  private final JwtUtil jwtUtil;

  @Autowired
  public AccountServiceImpl(AccountMapper mapper, MoneyMapper moneyMapper, AccountRepository accountRepository, JwtUtil jwtUtil) {
    this.mapper = mapper;
    this.moneyMapper = moneyMapper;
    this.accountRepository = accountRepository;
    this.jwtUtil = jwtUtil;
  }

  @Override
  public Account findByUsername(String username) {
    return accountRepository.findByUsername(username);
  }

  @Override
  @Transactional
  public Account updateMoney(BigDecimal value, String username) {
    Account user = findByUsername(username);
    user.setMoney(user.getMoney().add(value));
    return accountRepository.save(user);
  }

  @Override
  @Transactional
  public Account createUser(Account payload) {
    if (payload == null) {
      throw new IllegalArgumentException("Request payload can not be null");
    }
    if (findByUsername(payload.getUsername()) != null) {
      throw new IllegalArgumentException("Username has already exist");
    }
    payload.setPassword(new BCryptPasswordEncoder().encode(payload.getPassword()));
    return accountRepository.save(payload);
  }

  @Override
  public MoneyDTO getMoney(HttpServletRequest request) {
    return moneyMapper.fromEntity(jwtUtil.getUser(request));
  }
}
