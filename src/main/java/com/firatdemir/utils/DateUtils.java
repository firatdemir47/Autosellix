package com.firatdemir.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateUtils {

	public static String getcurrentDate(Date date) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return simpleDateFormat.format(date);
	}
}
