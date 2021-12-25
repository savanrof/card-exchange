package com.tlu.cardexchange.dto;

import java.util.Date;
import com.tlu.cardexchange.entity.Account;

public class InputCardDTO {

  private Integer seri;

  private Account account;

  private Date time;

  private Integer money;

  private String homeNetwork;

  public String getHomeNetwork() {
    return homeNetwork;
  }

  public void setHomeNetwork(String homeNetwork) {
    this.homeNetwork = homeNetwork;
  }

  private String status;

  private String transID;

  public Integer getSeri() {
    return seri;
  }

  public void setSeri(Integer seri) {
    this.seri = seri;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public Integer getMoney() {
    return money;
  }

  public void setMoney(Integer money) {
    this.money = money;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getTransID() {
    return transID;
  }

  public void setTransID(String transID) {
    this.transID = transID;
  }

}
