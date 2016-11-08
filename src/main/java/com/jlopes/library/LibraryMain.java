package com.jlopes.library;

import java.util.Scanner;

import com.jlopes.library.io.Reader;
import com.jlopes.library.io.Writer;
import com.jlopes.library.service.BookService;

public class LibraryMain {

	public static void main(String[] args) {
		LibraryController controller = new LibraryController(
				new LibraryManager(new BookService()), new Writer(),
				new Reader(new Scanner(System.in)), new MessageToUser());
		controller.menuOptions();
	}
}
