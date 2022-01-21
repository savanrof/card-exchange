package com.tlu.cardexchange.service.impl;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.tlu.cardexchange.dto.MoneyDTO;
import com.tlu.cardexchange.mapper.MoneyMapper;
import com.tlu.cardexchange.repository.MoneyRepository;
import com.tlu.cardexchange.service.MoneyService;
import com.tlu.cardexchange.util.JwtUtil;

public class MoneyServiceImpl implements MoneyService {
  private final MoneyRepository moneyRepository;
  private final MoneyMapper mapper;
  private final JwtUtil jwtUtil;

  @Autowired
  public MoneyServiceImpl(MoneyRepository moneyRepository, MoneyMapper mapper, JwtUtil jwtUtil) {
    this.moneyRepository = moneyRepository;
    this.mapper = mapper;
    this.jwtUtil = jwtUtil;
  }

  @Override
  public MoneyDTO getMoney(HttpServletRequest request) {
    return mapper.fromEntity(moneyRepository.findByAccount(jwtUtil.getUser(request)));
  }

}
