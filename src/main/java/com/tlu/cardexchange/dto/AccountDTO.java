package com.tlu.cardexchange.dto;

import java.math.BigDecimal;

public class AccountDTO {
  private String username;
  private String phone;
  private BigDecimal money;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public BigDecimal getMoney() {
    return money;
  }

  public void setMoney(BigDecimal money) {
    this.money = money;
  }

}
