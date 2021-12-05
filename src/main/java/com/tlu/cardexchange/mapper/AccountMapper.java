package com.tlu.cardexchange.mapper;

import org.springframework.stereotype.Component;

import com.tlu.cardexchange.dto.AccountDTO;
import com.tlu.cardexchange.entity.Account;

@Component
public class AccountMapper {

	public AccountDTO fromEntity(Account entity) {
		AccountDTO dto = new AccountDTO();
		dto.setUsername(entity.getUsername());
		dto.setPhone(entity.getPhone());
		dto.setMoney(entity.getMoney());
		return dto;
	}
}
