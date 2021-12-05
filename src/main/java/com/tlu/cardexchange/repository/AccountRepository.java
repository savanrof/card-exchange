package com.tlu.cardexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tlu.cardexchange.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

	Account findByUsername(String username);

}
