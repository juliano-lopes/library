package com.jlopes.library;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.jlopes.library.domain.Book;
import com.jlopes.library.domain.User;
import com.jlopes.library.service.LibraryService;

public class LibraryDisplayControlTest {
	@Test
	public void shouldReturnUserData() {
		LibraryDisplayControl displayControl = new LibraryDisplayControl();
		List<String> userData = displayControl.displayToGetUserData();
		assertTrue(!userData.isEmpty());
	}

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
	public void shouldReturnOptionChoosenInTheListWithAllTheBooks() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		LibraryDisplayControl displayControl = new LibraryDisplayControl();
		int option = displayControl.displayWithListBooks(library.getBooks());
		assertThat(option, is(3));
	}

	@Test
	public void shouldReturnOptionChoosenInTheListWithAvailableBooks() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		LibraryDisplayControl displayControl = new LibraryDisplayControl();
		User user = new User("Juliano", "julopys@hotmail.com", "31993709668");
		Book book = library.searchedBook("Se Houver Amanhã");
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
		LibraryDisplayControl displayControl = new LibraryDisplayControl();
		User user = new User("Juliano", "julopys@hotmail.com", "31993709668");
		Book book = library.searchedBook("Se Houver Amanhã");
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
