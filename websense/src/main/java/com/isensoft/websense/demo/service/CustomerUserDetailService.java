package com.isensoft.websense.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.isensoft.websense.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerUserDetailService implements UserDetailsService {

	private final UserRepository userRepository;
	 
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
	    return userRepository.findByEmail(userName).orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
	}
}
