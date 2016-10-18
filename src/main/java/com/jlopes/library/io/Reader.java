package com.jlopes.library.io;

import java.util.Scanner;

import com.jlopes.library.Utility;

public class Reader {

	private final Scanner scanner;

	public Reader(Scanner scanner) {
		this.scanner = scanner;
	}

	public String entry() {
		return scanner.nextLine();
	}

	public int parseToValidNumber(String value) {
		if ((Utility.isDataEmpty(value)) || (!Utility.isNumber(value))) {
			return 0;
		} else {
			return Integer.parseInt(value);
		}
	}

	public int validNumericInput(int value, int maxValue) {
		if (value > maxValue) {
			return 0;
		} else {
			return value;
		}
	}

}
