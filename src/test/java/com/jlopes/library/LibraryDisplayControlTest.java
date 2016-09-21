package com.jlopes.library;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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

	@Test
	public void shouldReturnBookTitleToSearch() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		LibraryDisplayControl displayControl = new LibraryDisplayControl(
				library);
		String result = displayControl.displaySearchBook();
		assertThat(result, is("terra em chamas"));
	}

	@Test
	public void shouldReturnOptionChoosenInTheListWithAllTheBooks() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		LibraryDisplayControl displayControl = new LibraryDisplayControl(
				library);
		int option = displayControl.displayWithAllTheBooks();
		assertThat(option, is(3));

	}
}
