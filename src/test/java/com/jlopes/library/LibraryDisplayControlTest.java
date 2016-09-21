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
		int option = displayControl.displayWithListBooks(library.getBooks());
		assertThat(option, is(3));
	}

	@Test
	public void shouldReturnOptionChoosenInTheListWithAvailableBooks() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		LibraryDisplayControl displayControl = new LibraryDisplayControl(
				library);
		Users user = new Users("Juliano", "julopys@hotmail.com", "31993709668");
		Books book = library.searchedBook("Se Houver Amanhã");
		CheckBooksOut myBook = new CheckBooksOut(user, book);
		library.checkingBookOut(myBook);
		int option = displayControl.displayWithListBooks(library
				.availableBooks());
		assertThat(option, is(2));

	}

	@Test
	public void shouldReturnOptionChoosenInTheListToReturn() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		LibraryDisplayControl displayControl = new LibraryDisplayControl(
				library);
		Users user = new Users("Juliano", "julopys@hotmail.com", "31993709668");
		Books book = library.searchedBook("Se Houver Amanhã");
		CheckBooksOut myBook = new CheckBooksOut(user, book);
		library.checkingBookOut(myBook);
		book = library.searchedBook("As Aventuras de Sharpe2");
		myBook = new CheckBooksOut(user, book);
		library.checkingBookOut(myBook);
		int option = displayControl.displayWithListBooksToReturn(library
				.checkedBooksOutByUser(user.getName()));
		assertThat(option, is(2));

	}

}
