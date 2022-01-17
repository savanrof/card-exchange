package com.tlu.cardexchange.dto;

import java.util.Date;

public class HistoryCardDTO {
  private String seri;

  private Date time;

  private Float money;

  private String homeNetwork;

  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getSeri() {
    return seri;
  }

  public void setSeri(String seri) {
    this.seri = seri;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public Float getMoney() {
    return money;
  }

  public void setMoney(Float money) {
    this.money = money;
  }

  public String getHomeNetwork() {
    return homeNetwork;
  }

  public void setHomeNetwork(String homeNetwork) {
    this.homeNetwork = homeNetwork;
  }


}
