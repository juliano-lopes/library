package com.jlopes.library;

import java.util.ArrayList;
import java.util.List;

public class LibraryMain extends Utility {

	public static void main(String[] args) {
		LibraryDisplayControl displayControl = new LibraryDisplayControl();

		displayControl.displayWellCome();
		List<String> userData = new ArrayList<String>();
		userData = displayControl.displayToGetUserData();
		Users user = new Users(userData.get(0), userData.get(1),
				userData.get(2));
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		LibraryController controller = new LibraryController(displayControl,
				library, user);

		controller
				.setOption(controller.displayControl.displayWithMenuOptions());
		controller.decisionControl();
	}

}
