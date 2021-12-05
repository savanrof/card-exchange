package com.tlu.cardexchange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tlu.cardexchange.entity.Account;
import com.tlu.cardexchange.mapper.AccountMapper;
import com.tlu.cardexchange.repository.AccountRepository;
import com.tlu.cardexchange.service.AccountService;

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

	private final AccountMapper mapper;
	private final AccountRepository accountRepository;

	@Autowired
	public AccountServiceImpl(AccountMapper mapper, AccountRepository accountRepository) {
		this.mapper = mapper;
		this.accountRepository = accountRepository;
	}

	@Override
	public Account findByUsername(String username) {
		return accountRepository.findByUsername(username);
	}

}
