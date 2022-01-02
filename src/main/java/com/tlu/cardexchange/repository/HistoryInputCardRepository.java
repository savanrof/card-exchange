package com.tlu.cardexchange.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tlu.cardexchange.entity.Account;
import com.tlu.cardexchange.entity.HistoryInputCard;

@Repository
public interface HistoryInputCardRepository extends JpaRepository<HistoryInputCard, Integer> {
  HistoryInputCard findByTransID(String transID);

  List<HistoryInputCard> findByAccount(Account account);
}
