package com.jlopes.library;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.jlopes.library.domain.Book;
import com.jlopes.library.domain.User;
import com.jlopes.library.exception.LibraryManagerDataShouldNotBeNullException;
import com.jlopes.library.service.LibraryService;

public class LibraryManagerTest {
	@Test(expected = LibraryManagerDataShouldNotBeNullException.class)
	public void shouldReturnLibraryManagerDataShouldNotBeNullException() {
		List<Book> books = null;
		new LibraryManager(books);
	}

	@Test
	public void shouldReturnTrueIfQuantityBooksBiggerThanZero() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		int quantityBooks = library.quantityBooks();
		assertThat((quantityBooks > 0), is(true));
	}

	@Test
	public void shouldReturnBookAuthorIfBookFound() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		Book book = library.searchedBook("Se Houver Amanhã");
		String author = book.getAuthor();
		assertThat(author, is("Sidney Sheldon"));
	}

	@Test
	public void shouldReturnNullBecauseBookTitleNotExists() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		Book book = library.searchedBook("Ordem dos Arqueiros");
		assertNull(book);
	}

	@Test
	public void shouldReturnTrueIfBookCheckedOut() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		User user = new User("Juliano", "julopys@hotmail.com", "31993709668");
		Book searchedBook = library.searchedBook("Se Houver Amanhã");
		CheckBooksOut checkBookOut = new CheckBooksOut(user, searchedBook);
		boolean result = library.checkingBookOut(checkBookOut);
		assertTrue(result);
	}

	@Test
	public void shouldReturnListWithCheckedBooksOut() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		User user = new User("Juliano", "julopys@hotmail.com", "31993709668");
		Book searchedBook = library.searchedBook("Se Houver Amanhã");
		CheckBooksOut checkBookOut = new CheckBooksOut(user, searchedBook);
		library.checkingBookOut(checkBookOut);
		searchedBook = library.searchedBook("As Aventuras de Sharpe1");
		CheckBooksOut checkBookOut2 = new CheckBooksOut(user, searchedBook);
		library.checkingBookOut(checkBookOut2);
		List<Book> result = library.checkedBooksOut();
		assertTrue(result != null);
	}

	@Test
	public void shouldReturnBookTitleFirstOneCheckedOut() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		User user = new User("Juliano", "julopys@hotmail.com", "31993709668");
		Book searchedBook = library.searchedBook("Se Houver Amanhã");
		CheckBooksOut checkBookOut = new CheckBooksOut(user, searchedBook);
		library.checkingBookOut(checkBookOut);
		searchedBook = library.searchedBook("As Aventuras de Sharpe1");
		CheckBooksOut checkBookOut2 = new CheckBooksOut(user, searchedBook);
		library.checkingBookOut(checkBookOut2);
		List<Book> checkedBooksOut = library.checkedBooksOut();
		String result = checkedBooksOut.get(0).getTitle();
		assertThat(result, is("Se Houver Amanhã"));
	}

	@Test
	public void shouldReturnQuantityAvailableBooks() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());

		User user = new User("Juliano", "julopys@hotmail.com", "31993709668");
		Book searchedBook = library.searchedBook("Se Houver Amanhã");
		CheckBooksOut checkBookOut = new CheckBooksOut(user, searchedBook);
		library.checkingBookOut(checkBookOut);
		searchedBook = library.searchedBook("As Aventuras de Sharpe1");
		CheckBooksOut checkBookOut2 = new CheckBooksOut(user, searchedBook);
		library.checkingBookOut(checkBookOut2);

		List<Book> availableBooks = library.availableBooks();
		int quantityAvailableBooks = availableBooks.size();
		int quantityBooks = library.quantityBooks();
		assertThat(quantityAvailableBooks, is(quantityBooks - 2));
	}

	@Test
	public void shouldReturnQuantityBooksThisUserCheckedOut() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());

		User user = new User("Juliano", "julopys@hotmail.com", "31993709668");
		Book searchedBook = library.searchedBook("Se Houver Amanhã");
		CheckBooksOut checkBookOut = new CheckBooksOut(user, searchedBook);
		library.checkingBookOut(checkBookOut);
		searchedBook = library.searchedBook("As Aventuras de Sharpe1");
		CheckBooksOut checkBookOut2 = new CheckBooksOut(user, searchedBook);
		library.checkingBookOut(checkBookOut2);

		List<CheckBooksOut> checkedBooksOut = library
				.checkedBooksOutByUser("Juliano");
		int quantityCheckedBooksOutByUser = checkedBooksOut.size();
		assertThat(quantityCheckedBooksOutByUser, is(2));
	}

	@Test
	public void shouldReturnTrueIfQuantityCheckedBooksOutByUserIsLeastAfterCheckBookIn() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		User user = new User("Juliano", "julopys@hotmail.com", "31993709668");
		Book searchedBook = library.searchedBook("Se Houver Amanhã");
		CheckBooksOut checkBookOut = new CheckBooksOut(user, searchedBook);
		library.checkingBookOut(checkBookOut);
		searchedBook = library.searchedBook("As Aventuras de Sharpe1");
		CheckBooksOut checkBookOut2 = new CheckBooksOut(user, searchedBook);
		library.checkingBookOut(checkBookOut2);
		List<CheckBooksOut> checkedBooksOut = library
				.checkedBooksOutByUser("Juliano");
		int quantityCheckedBooksOutByUser = checkedBooksOut.size();
		library.checkingBookIn(checkedBooksOut.get(0));
		checkedBooksOut = library.checkedBooksOutByUser("Juliano");

		int quantityCheckedBooksOutByUserAfterDevolution = checkedBooksOut
				.size();
		assertThat(
				quantityCheckedBooksOutByUserAfterDevolution < quantityCheckedBooksOutByUser,
				is(true));

	}

}
