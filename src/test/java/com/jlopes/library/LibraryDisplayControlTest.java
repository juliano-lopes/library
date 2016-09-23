package com.jlopes.library;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.jlopes.library.domain.Book;

import com.jlopes.library.service.LibraryService;

public class LibraryDisplayControlTest {
	@Test
	public void shouldReturnAMenuOption() {

		LibraryDisplayControl displayControl = new LibraryDisplayControl();
		int option = displayControl.displayWithMenuOptions();
		assertTrue(option > 0);
	}

	@Test
	public void shouldReturnBookTitleToSearch() {
		LibraryDisplayControl displayControl = new LibraryDisplayControl();
		String result = displayControl.displaySearchBook();
		assertThat(result, is("terra em chamas"));
	}

	@Test
	public void shouldReturnTrueInTheListWithAllTheBooks() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService);
		LibraryDisplayControl displayControl = new LibraryDisplayControl();
		int option = displayControl.displayWithListBooks(library.getBooks());
		assertThat(option > 0, is(true));
	}

	@Test
	public void shouldReturnTrueInTheListWithAvailableBooks() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService);
		LibraryDisplayControl displayControl = new LibraryDisplayControl();
		Book book = library.searchedBook("Se Houver Amanhã");
		library.checkingBookOut(book);
		int option = displayControl.displayWithListBooks(library
				.availableBooks());
		assertThat(option > 0, is(true));
	}

	@Test
	public void shouldReturnTrueInTheListToReturn() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService);
		LibraryDisplayControl displayControl = new LibraryDisplayControl();
		Book book = library.searchedBook("Se Houver Amanhã");
		library.checkingBookOut(book);
		book = library.searchedBook("As Aventuras de Sharpe2");
		library.checkingBookOut(book);
		int option = displayControl.displayWithListBooks(library
				.getCheckedBooksOut());
		assertThat(option > 0, is(true));

	}

}
