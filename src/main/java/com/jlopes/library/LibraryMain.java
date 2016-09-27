package com.jlopes.library;

import com.jlopes.library.service.BookService;

public class LibraryMain {

	public static void main(String[] args) {
		LibraryDisplayControl displayControl = new LibraryDisplayControl();
		BookService bookService = new BookService();
		LibraryManager library = new LibraryManager(bookService);
		LibraryController controller = new LibraryController(displayControl,
				library);
		controller.displayControl.displayWellCome();
		controller
				.setOption(controller.displayControl.displayWithMenuOptions());
		controller.decisionControl();
	}

}
