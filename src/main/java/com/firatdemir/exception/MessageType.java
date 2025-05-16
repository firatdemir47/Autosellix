package com.firatdemir.exception;

import lombok.Getter;

@Getter
public enum MessageType {
	NO_RECORD_EXIST("1004", "kayıt bulunamadı"), TOKEN_IS_EXPIRED("1005", "tokenin süresi bitmiştir "),
	USERNANE_NOT_FOUND("1006", "username bulunamadı"), GENERAL_EXCEPTION("9999", "genel bir hata oluştu");

	private String code;

	private String message;

	MessageType(String code, String message) {

		this.code = code;
		this.message = message;
	}
}
