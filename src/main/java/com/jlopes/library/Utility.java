package com.jlopes.library;

public class Utility {
	protected static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isDataEmpty(String... params) {
		for (String value : params) {
			if (value.equals("")) {
				return true;
			}
		}
		return false;
	}

	protected static boolean isZero(String value) {
		if (value.equals("0")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNumber(String value) {
		for (int index = 0; index < value.length(); index++) {
			if (!Character.isDigit(value.charAt(index))) {
				return false;
			}
		}
		return true;
	}
}
