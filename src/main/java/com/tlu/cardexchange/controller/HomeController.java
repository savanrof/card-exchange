package com.tlu.cardexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tlu.cardexchange.entity.Account;
import com.tlu.cardexchange.service.AccountService;

@RestController
public class HomeController {

  private final AccountService accountService;

  @Autowired
  public HomeController(AccountService accountService) {
    super();
    this.accountService = accountService;
  }



  @GetMapping("/home")
  @CrossOrigin
  public ResponseEntity<String> home() {
    Account account = accountService.findByUsername("admin");
    return ResponseEntity.ok("This is home page. " + account.getPhone());
  }
}
