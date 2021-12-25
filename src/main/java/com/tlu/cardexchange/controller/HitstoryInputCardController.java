package com.tlu.cardexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tlu.cardexchange.service.HistoryInputCardService;

@RestController
public class HitstoryInputCardController {
  private final HistoryInputCardService inputCardService;

  @Autowired
  public HitstoryInputCardController(HistoryInputCardService inputCardService) {
    super();
    this.inputCardService = inputCardService;
  }

  @GetMapping("/transId/check")
  public ResponseEntity<Boolean> transIdCheck(@RequestParam String transId) {
    return ResponseEntity.ok(inputCardService.transIdCheck(transId));
  }

}
