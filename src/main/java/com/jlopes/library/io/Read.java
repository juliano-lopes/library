package com.jlopes.library.io;

import java.util.Scanner;

import com.jlopes.library.Utility;

public class Read {

	private static Scanner scanner;

	public static String entry() {
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public static int parseToValidNumber(String value) {
		if ((Utility.isDataEmpty(value)) || (!Utility.isNumber(value))) {
			Write.invalidOptionMessage();
			return 0;
		} else {
			return Integer.parseInt(value);
		}
	}

	public static int validNumericInput(int value, int maxValue) {
		if (value > maxValue) {
			Write.invalidOptionMessage();
			return 0;
		} else {
			return value;
		}
	}

}
