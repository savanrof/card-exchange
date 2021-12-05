package com.tlu.cardexchange.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tlu.cardexchange.config.JwtTokenUtil;
import com.tlu.cardexchange.entity.Account;
import com.tlu.cardexchange.repository.AccountRepository;

@Component
public final class JwtUtil {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public Account getUser(HttpServletRequest request) {
		return accountRepository
				.findByUsername(jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").split(" ")[1]));
	}
}
