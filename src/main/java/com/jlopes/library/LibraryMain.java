package com.jlopes.library;

import com.jlopes.library.service.BookService;

public class LibraryMain {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		LibraryManager library = new LibraryManager(bookService);
		LibraryController controller = new LibraryController(library);
		controller.menuOptions();
	}
}
