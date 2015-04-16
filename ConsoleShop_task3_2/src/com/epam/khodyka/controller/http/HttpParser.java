package com.epam.khodyka.controller.http;

public class HttpParser {

	public static String parseCommandString(String request) {
		String[] arr = request.split("\\s");
		if (arr.length > 2) {
			return parse(arr[1]);
		}
		return "";
	}

	private static String parse(String adressString) {
		String[] arr = adressString.split("/");
		return arr[arr.length - 1];
	}

}
