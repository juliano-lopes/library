package com.jlopes.library.io;

import java.util.Scanner;

public class Input {

	private static Scanner scanner;

	public static String entry() {
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
