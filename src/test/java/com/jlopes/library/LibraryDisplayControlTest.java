package com.jlopes.library;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.jlopes.library.domain.Book;

import com.jlopes.library.service.BookService;

public class LibraryDisplayControlTest {
	@Test
	public void shouldReturnMenuOption() {

		LibraryDisplayControl displayControl = new LibraryDisplayControl();
		int option = displayControl.displayWithMenuOptions();
		assertThat(option, is(1));
	}

	@Test
	public void shouldReturnBookTitleToSearch() {
		LibraryDisplayControl displayControl = new LibraryDisplayControl();
		String result = displayControl.displaySearchBook();
		assertThat(result, is("terra em chamas"));
	}

	@Test
	public void shouldReturnTrueInTheListWithAllTheBooks() {
		BookService bookService = new BookService();
		LibraryManager library = new LibraryManager(bookService);
		LibraryDisplayControl displayControl = new LibraryDisplayControl();
		int option = displayControl.displayWithListBooks(library.getBooks());
		assertThat(option > 0, is(true));
	}

	@Test
	public void shouldReturnTrueInTheListWithAvailableBooks() {
		BookService bookService = new BookService();
		LibraryManager library = new LibraryManager(bookService);
		LibraryDisplayControl displayControl = new LibraryDisplayControl();
		Book book = library.searchedBook("Se Houver Amanhã");
		library.checkingBookOut(book);
		int option = displayControl.displayWithListBooks(library
				.availableBooks());
		assertThat(option > 0, is(true));
	}

	@Test
	public void shouldReturnTrueInTheListToReturn() {
		BookService bookService = new BookService();
		LibraryManager library = new LibraryManager(bookService);
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
