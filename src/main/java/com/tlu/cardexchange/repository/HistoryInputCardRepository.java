package com.tlu.cardexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tlu.cardexchange.entity.HistoryInputCard;

@Repository
public interface HistoryInputCardRepository extends JpaRepository<HistoryInputCard, Integer> {
  HistoryInputCard findByTransID(String transID);
}
