package com.jlopes.library;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.jlopes.library.domain.Book;
import com.jlopes.library.service.BookService;

public class LibraryDisplayControlTest {
	private LibraryManager library;
	private LibraryDisplayControl displayControl;

	@Before
	public void setUp() {
		BookService bookService = new BookService();
		library = new LibraryManager(bookService);
		displayControl = new LibraryDisplayControl();
	}

	@Test
	public void shouldReturnMenuOption() {
		MenuOptions option = displayControl.displayWithMenuOptions();
		assertThat(option, is(MenuOptions.SEARCH_BOOK));
	}

	@Test
	public void shouldReturnTrueInTheListWithAllTheBooks() {
		int option = displayControl.displayWithListBooks(library.getBooks());
		assertThat(option > 0, is(true));
	}

	@Test
	public void shouldReturnTrueInTheListWithAvailableBooks() {
		Book book = library.searchedBook("Se Houver Amanh�");
		library.checkingBookOut(book);
		int option = displayControl.displayWithListBooks(library
				.availableBooks());
		assertThat(option > 0, is(true));
	}

	@Test
	public void shouldReturnTrueInTheListToReturn() {
		Book book = library.searchedBook("Se Houver Amanh�");
		library.checkingBookOut(book);
		book = library.searchedBook("As Aventuras de Sharpe2");
		library.checkingBookOut(book);
		int option = displayControl.displayWithListBooks(library
				.getCheckedBooksOut());
		assertThat(option > 0, is(true));

	}

}
