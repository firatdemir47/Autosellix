package com.firatdemir.controller;

import com.firatdemir.dto.AuthRequest;
import com.firatdemir.dto.AuthResponse;
import com.firatdemir.dto.DtoUser;
import com.firatdemir.dto.RefreshTokenRequest;
import com.firatdemir.repository.RefreshTokenRepository;

public interface IRestAuthenticationController {

	public RootEntity<DtoUser> register(AuthRequest input);

	public RootEntity<AuthResponse> authenticate(AuthRequest input);

	public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);
}
