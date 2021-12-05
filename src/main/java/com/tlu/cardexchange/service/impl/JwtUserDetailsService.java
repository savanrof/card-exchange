package com.tlu.cardexchange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tlu.cardexchange.entity.Account;
import com.tlu.cardexchange.service.AccountService;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account user = accountService.findByUsername(username);
		UserBuilder userBuilder = null;
		if (user != null) {
			userBuilder = User.withUsername(username);
			userBuilder.password(user.getPassword());
			userBuilder.roles("ANY_ROLE");
		} else {
			throw new UsernameNotFoundException("Username not found");
		}
		return userBuilder.build();
	}
}
