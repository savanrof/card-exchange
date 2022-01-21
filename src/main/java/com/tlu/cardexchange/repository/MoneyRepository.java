package com.tlu.cardexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tlu.cardexchange.entity.Account;
import com.tlu.cardexchange.entity.WithdrawMoney;

@Repository
public interface MoneyRepository extends JpaRepository<WithdrawMoney, Integer> {
  WithdrawMoney findByAccount(Account account);
}
