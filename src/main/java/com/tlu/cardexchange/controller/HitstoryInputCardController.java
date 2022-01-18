package com.tlu.cardexchange.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tlu.cardexchange.dto.HistoryCardDTO;
import com.tlu.cardexchange.dto.InputCardDTO;
import com.tlu.cardexchange.service.HistoryInputCardService;

@RestController
@RequestMapping("/input-card")
public class HitstoryInputCardController {
  private final HistoryInputCardService inputCardService;

  @Autowired
  public HitstoryInputCardController(HistoryInputCardService inputCardService) {
    super();
    this.inputCardService = inputCardService;
  }

  @CrossOrigin
  @GetMapping(value = "/transId/check")
  public ResponseEntity<Boolean> transIdCheck(@RequestParam String transId) {
    return ResponseEntity.ok(inputCardService.transIdCheck(transId));
  }

  @CrossOrigin
  @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HistoryCardDTO> create(@RequestBody InputCardDTO dto, HttpServletRequest request) {
    return ResponseEntity.ok(inputCardService.create(dto, request));
  }

  @CrossOrigin
  @GetMapping(value = "/all")
  public ResponseEntity<List<HistoryCardDTO>> getAll(HttpServletRequest request) {
    return ResponseEntity.ok(inputCardService.getHistoryInputCardByUsername(request));
  }
}
