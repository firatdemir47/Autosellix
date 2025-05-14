package com.firatdemir.handler;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.firatdemir.exception.BaseException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { BaseException.class })
	public ResponseEntity<ApiError<?>> handleBaseException(BaseException ex, WebRequest request) {
		return ResponseEntity.badRequest().body(createApierror(ex.getMessage(), request));

	}

	public ResponseEntity<ApiError<Map<String, List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {

		Map<String, List<String>> map = new HashMap<>();
		for (ObjectError objError : ex.getBindingResult().getAllErrors()) {
			String fieldname = ((FieldError) objError).getField();

			if (map.containsKey(fieldname)) {
				map.put(fieldname, addvalue(map.get(fieldname), objError.getDefaultMessage()));
			} else {
				map.put(fieldname, addvalue(new ArrayList<>(), objError.getDefaultMessage()));
			}
		}

		return ResponseEntity.badRequest().body(createApierror(map, request));

	}

	private List<String> addvalue(List<String> list, String newValue) {

		list.add(newValue);
		return list;
	}

	private String getHostName() {
		try {
			return Inet4Address.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "";
	}

	public <E> ApiError<E> createApierror(E message, WebRequest request) {
		ApiError<E> apiError = new ApiError<>();
		apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

		Exception<E> exception = new Exception<>();

		exception.setPath(request.getDescription(false).substring(4));
		exception.setCreateTime(new Date(0));
		exception.setMessage(message);
		exception.setHostName(getHostName());

		apiError.setException(exception);
		return apiError;
	}
}
