package com.epam.khodyka.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class DateFormatter {

	public static Date toDate(String source) {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		try {
			return format.parse(source);
		} catch (ParseException e) {
			return null;
		}
	}
}
