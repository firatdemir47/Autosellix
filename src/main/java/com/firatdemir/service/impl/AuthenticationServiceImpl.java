package com.firatdemir.service.impl;

import java.sql.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.firatdemir.dto.AuthRequest;
import com.firatdemir.dto.DtoUser;
import com.firatdemir.model.User;
import com.firatdemir.repository.UserRepository;
import com.firatdemir.service.IAuthenticationService;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	private User createUser(AuthRequest input) {

		User user = new User();
		user.setCreatetime(new Date(0));
		user.setUsername(input.getUsername());
		user.setPassword(passwordEncoder.encode(input.getPassword()));

		return user;
	}

	@Override
	public DtoUser register(AuthRequest input) {
		DtoUser dtoUser = new DtoUser();
		User savedUser = userRepository.save(createUser(input));
		BeanUtils.copyProperties(savedUser, dtoUser);
		return dtoUser;
	}

}
