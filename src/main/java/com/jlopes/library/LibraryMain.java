package com.jlopes.library;

import com.jlopes.library.service.LibraryService;

public class LibraryMain {

	public static void main(String[] args) {
		LibraryDisplayControl displayControl = new LibraryDisplayControl();
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService);
		LibraryController controller = new LibraryController(displayControl,
				library);
		controller.displayControl.displayWellCome();
		controller
				.setOption(controller.displayControl.displayWithMenuOptions());
		controller.decisionControl();
	}

}
