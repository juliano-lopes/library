package com.jlopes.library.io;

import java.util.Scanner;

public class Reader {

	private final Scanner scanner;

	public Reader(Scanner scanner) {
		this.scanner = scanner;
	}

	public String entry() {
		return scanner.nextLine();
	}

	public int parseToValidNumber(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return 0;
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
