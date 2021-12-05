package com.tlu.cardexchange.service;

import org.springframework.stereotype.Service;

import com.tlu.cardexchange.entity.Account;

@Service
public interface AccountService {
	Account findByUsername(String username);
}
