package com.isensoft.websense.demo.controller;

import java.util.Map;
import java.util.Collections;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isensoft.websense.demo.entity.User;
import com.isensoft.websense.demo.jwt.JwtTokenProvider;
import com.isensoft.websense.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    
	@PostMapping("/join")
	public Long join(@RequestBody Map<String, String> user) {

		return userRepository.save(User.builder().email(user.get("email"))
                .password(passwordEncoder.encode(user.get("password")))
                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER로 설정
                .build()).getId();

	}
	
	@PostMapping("/login")
	public String login(@RequestBody Map<String, String> user) {
		
		User member = userRepository.findByEmail(user.get("email"))
				.orElseThrow(() -> new IllegalArgumentException("not member"));
		
		if (passwordEncoder.matches(user.get("password"), member.getPassword())) {
			throw new IllegalArgumentException("wrong password.");
		}
		
		return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
	}
	
	@PostMapping("/admin/dashboard")
	public String adminDashboard(@RequestBody Map<String, String> dashmap) {
		
		return "dashboard";
	}
}
