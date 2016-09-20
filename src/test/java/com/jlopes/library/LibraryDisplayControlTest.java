package com.jlopes.library;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LibraryDisplayControlTest {
	@Test
	public void shouldReturnAMenuOption() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		LibraryDisplayControl displayControl = new LibraryDisplayControl(
				library);
		int option = displayControl.menuOptions();
		assertTrue(option > 0);

	}
}
