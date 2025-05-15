package com.firatdemir.jwt;

import java.io.IOException;
import java.rmi.server.ExportException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.firatdemir.exception.BaseException;
import com.firatdemir.exception.ErrorMessage;
import com.firatdemir.exception.MessageType;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JWTService jwtService;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header = request.getHeader("Authorization");

		if (header == null) {
			filterChain.doFilter(request, response);
			return;
		}
		String token;
		String username;

		token = header.substring(7);
		try {
			username = jwtService.getUsernameByToken(token);
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetailss = userDetailsService.loadUserByUsername(username);
				if (userDetailss != null && jwtService.isTokenValid(token)) {
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
							username, null, userDetailss.getAuthorities());
					authenticationToken.setDetails(userDetailss);

					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
			}
		} catch (ExpiredJwtException ex) {
			throw new BaseException(new ErrorMessage(MessageType.TOKEN_IS_EXPIRED, ex.getMessage()));
		} catch (Exception ex) {
			throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION, ex.getMessage()));

		}

	}

}
