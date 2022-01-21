package com.tlu.cardexchange.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tlu.cardexchange.dto.MoneyDTO;
import com.tlu.cardexchange.service.MoneyService;

@RestController
@RequestMapping("/money")
public class MoneyController {

  private final MoneyService moneyService;

  @Autowired
  public MoneyController(MoneyService moneyService) {
    this.moneyService = moneyService;
  }

  @GetMapping("/")
  @CrossOrigin
  public ResponseEntity<MoneyDTO> getMoney(HttpServletRequest request) {
    return ResponseEntity.ok(moneyService.getMoney(request));
  }
}
