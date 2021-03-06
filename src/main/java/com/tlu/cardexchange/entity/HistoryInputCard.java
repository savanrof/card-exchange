package com.tlu.cardexchange.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historyinputcard")
public class HistoryInputCard {

  @Id
  @Column(name = "seri")
  private String seri;

  @ManyToOne
  @JoinColumn(name = "Username")
  private Account account;

  @ManyToOne
  @JoinColumn(name = "idhome_network")
  private Discount homeNetwork;

  @Column(name = "Time")
  private Date time;

  @Column(name = "money")
  private Float money;

  @Column(name = "status")
  private String status;

  @Column(name = "transID", unique = true)
  private String transID;

  public String getTransID() {
    return transID;
  }

  public void setTransID(String transID) {
    this.transID = transID;
  }

  public String getSeri() {
    return seri;
  }

  public void setSeri(String seri) {
    this.seri = seri;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Discount getHomeNetwork() {
    return homeNetwork;
  }

  public void setHomeNetwork(Discount homeNetwork) {
    this.homeNetwork = homeNetwork;
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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
