package com.firatdemir.exception;

import lombok.Getter;

@Getter
public enum MessageType {
	NO_RECORD_EXIST("1004", "kayıt bulunamadı"), TOKEN_IS_EXPIRED("1005", "tokenin süresi bitmiştir "),
	USERNANE_NOT_FOUND("1006", "username bulunamadı"),
	USERNAME_OR_PASSWORD_INVALID("1007", "kullanıcı adı veya şifre hatalı"),
	REFRESH_TOKEN_NOT_FOUND("1008", "refresh token bulunamadı"),
	REFRESH_TOKEN_IS_EXPIRED("1009", "refres tokenın süresi bitmiştir"),
	CUSTOMER_AMOUNT_IS_NOT_ENOUGH("1001","müşterinin parası yeterli değildir "),
	CAR_STATUS_IS_ALREADY_SALED("1012","araba satılmış göründüğü için satılamaz"),
	CURRENY_RATES_IS_OCCURED("1010", "döviz kuru alınamadı"), GENERAL_EXCEPTION("9999", "genel bir hata oluştu");

	private String code;

	private String message;

	MessageType(String code, String message) {

		this.code = code;
		this.message = message;
	}
}
