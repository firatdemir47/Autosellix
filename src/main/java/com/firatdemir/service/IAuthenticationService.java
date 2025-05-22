package com.firatdemir.service;

import com.firatdemir.dto.AuthRequest;
import com.firatdemir.dto.AuthResponse;
import com.firatdemir.dto.DtoUser;
import com.firatdemir.dto.RefreshTokenRequest;

public interface IAuthenticationService {

	public DtoUser register(AuthRequest input);

	public AuthResponse authenticate(AuthRequest input);

	public AuthResponse refreshToken(RefreshTokenRequest input);
}
