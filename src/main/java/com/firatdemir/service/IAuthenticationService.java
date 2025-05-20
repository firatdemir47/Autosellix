package com.firatdemir.service;


import com.firatdemir.dto.AuthRequest;
import com.firatdemir.dto.AuthResponse;
import com.firatdemir.dto.DtoUser;

public interface IAuthenticationService {
	
	public DtoUser register(AuthRequest input);
	
	public AuthResponse authenticate(AuthRequest input);
}
