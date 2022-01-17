package com.tlu.cardexchange.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tlu.cardexchange.dto.HistoryCardDTO;
import com.tlu.cardexchange.dto.InputCardDTO;
import com.tlu.cardexchange.entity.Discount;
import com.tlu.cardexchange.entity.HistoryInputCard;
import com.tlu.cardexchange.mapper.InputCardMapper;
import com.tlu.cardexchange.repository.HistoryInputCardRepository;
import com.tlu.cardexchange.service.DiscountService;
import com.tlu.cardexchange.service.HistoryInputCardService;
import com.tlu.cardexchange.util.ErrorCodeUtil;
import com.tlu.cardexchange.util.JwtUtil;

@Service
public class HistoryInputCardSerivceImpl implements HistoryInputCardService {

  private final HistoryInputCardRepository inputCardRepository;
  private final DiscountService discountService;
  private final JwtUtil jwtUtil;
  private final InputCardMapper mapper;
  private final ErrorCodeUtil codeUtil;

  @Autowired
  public HistoryInputCardSerivceImpl(HistoryInputCardRepository inputCardRepository, DiscountService discountService, JwtUtil jwtUtil, InputCardMapper mapper, ErrorCodeUtil codeUtil) {
    this.inputCardRepository = inputCardRepository;
    this.discountService = discountService;
    this.jwtUtil = jwtUtil;
    this.mapper = mapper;
    this.codeUtil = codeUtil;
  }

  @Override
  public HistoryInputCard getByTransID(String transID) {
    return inputCardRepository.findByTransID(transID);
  }

  @Override
  public boolean transIdCheck(String transID) {
    HistoryInputCard inputCard = inputCardRepository.findByTransID(transID);
    return inputCard != null;
  }

  @Override
  @Transactional
  public HistoryInputCard create(InputCardDTO dto, HttpServletRequest request) {
    Discount discount = discountService.findByNetworkAndPrice(dto.getHomeNetwork(), dto.getMoney());
    HistoryInputCard inputCard = new HistoryInputCard();
    inputCard.setAccount(jwtUtil.getUser(request));
    inputCard.setSeri(dto.getSeri());
    inputCard.setHomeNetwork(discount);
    inputCard.setMoney(Float.parseFloat(dto.getMoney().toString()));
    inputCard.setStatus(codeUtil.getMessageFromCode(dto.getStatus()));
    inputCard.setTime(dto.getTime());
    inputCard.setTransID(dto.getTransID());
    return inputCardRepository.save(inputCard);
  }

  @Override
  public List<HistoryCardDTO> getHistoryInputCardByUsername(HttpServletRequest request) {
    return inputCardRepository.findByAccount(jwtUtil.getUser(request)).stream().map(mapper::fromEntity).collect(Collectors.toList());
  }

}
