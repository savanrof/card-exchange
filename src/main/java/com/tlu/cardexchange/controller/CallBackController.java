package com.tlu.cardexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tlu.cardexchange.service.CallBackService;

@RestController
public class CallBackController {
  private final CallBackService callBackService;

  @Autowired
  public CallBackController(CallBackService callBackService) {
    this.callBackService = callBackService;
  }

  @GetMapping("/gach-the")
  public ResponseEntity<String> callBack(@RequestParam Integer errorCode, @RequestParam String data, @RequestParam String transID, @RequestParam String msg, @RequestParam String sign) {
    callBackService.callBackResult(errorCode, data, transID, msg, sign);
    return ResponseEntity.ok("Error code: " + errorCode + ", data: " + data + ", transID " + transID + ", msg " + msg + ", sign " + sign);
  }

}
