package com.jlopes.library;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.jlopes.library.domain.Book;
import com.jlopes.library.service.BookService;

public class LibraryManagerTest {

	@Test
	public void shouldReturnTrueIfQuantityBooksBiggerThanZero() {
		BookService bookService = new BookService();
		LibraryManager library = new LibraryManager(bookService);
		int quantityBooks = library.getBooks().size();
		assertThat((quantityBooks > 0), is(true));
	}

	@Test
	public void shouldReturnBookAuthorIfBookFound() {
		BookService bookService = new BookService();
		LibraryManager library = new LibraryManager(bookService);
		Book book = library.searchedBook("Se Houver Amanhã");
		String author = book.getAuthor();
		assertThat(author, is("Sidney Sheldon"));
	}

	@Test
	public void shouldReturnNullBecauseBookTitleNotExists() {
		BookService bookService = new BookService();
		LibraryManager library = new LibraryManager(bookService);
		Book book = library.searchedBook("Ordem dos Arqueiros");
		assertNull(book);
	}

	@Test
	public void shouldReturnTrueIfBookCheckedOut() {
		BookService bookService = new BookService();
		LibraryManager library = new LibraryManager(bookService);
		Book searchedBook = library.searchedBook("Se Houver Amanhã");
		boolean result = library.checkingBookOut(searchedBook);
		assertTrue(result);
	}

	@Test
	public void shouldReturnListWithCheckedBooksOut() {
		BookService bookService = new BookService();
		LibraryManager library = new LibraryManager(bookService);
		Book searchedBook = library.searchedBook("Se Houver Amanhã");
		library.checkingBookOut(searchedBook);
		searchedBook = library.searchedBook("As Aventuras de Sharpe1");
		library.checkingBookOut(searchedBook);
		List<Book> result = library.getCheckedBooksOut();
		assertTrue(result != null);
	}

	@Test
	public void shouldReturnBookTitleFirstOneCheckedOut() {
		BookService bookService = new BookService();
		LibraryManager library = new LibraryManager(bookService);
		Book searchedBook = library.searchedBook("Se Houver Amanhã");
		library.checkingBookOut(searchedBook);
		searchedBook = library.searchedBook("As Aventuras de Sharpe1");
		library.checkingBookOut(searchedBook);
		List<Book> checkedBooksOut = library.getCheckedBooksOut();
		String result = checkedBooksOut.get(0).getTitle();
		assertThat(result, is("Se Houver Amanhã"));
	}

	@Test
	public void shouldReturnQuantityAvailableBooks() {
		BookService bookService = new BookService();
		LibraryManager library = new LibraryManager(bookService);

		Book searchedBook = library.searchedBook("Se Houver Amanhã");
		library.checkingBookOut(searchedBook);
		searchedBook = library.searchedBook("As Aventuras de Sharpe1");
		library.checkingBookOut(searchedBook);

		List<Book> availableBooks = library.availableBooks();
		int quantityAvailableBooks = availableBooks.size();
		int quantityBooks = library.getBooks().size();
		assertThat(quantityAvailableBooks, is(quantityBooks - 2));
	}

	@Test
	public void shouldReturnQuantityCheckedBooksOut() {
		BookService bookService = new BookService();
		LibraryManager library = new LibraryManager(bookService);

		Book searchedBook = library.searchedBook("Se Houver Amanhã");
		library.checkingBookOut(searchedBook);
		searchedBook = library.searchedBook("As Aventuras de Sharpe1");
		library.checkingBookOut(searchedBook);

		List<Book> checkedBooksOut = library.getCheckedBooksOut();
		int quantityCheckedBooksOut = checkedBooksOut.size();
		assertThat(quantityCheckedBooksOut, is(2));
	}

	@Test
	public void shouldReturnTrueIfQuantityCheckedBooksOutIsLeastAfterCheckBookIn() {
		BookService bookService = new BookService();
		LibraryManager library = new LibraryManager(bookService);
		Book searchedBook = library.searchedBook("Se Houver Amanhã");
		library.checkingBookOut(searchedBook);
		searchedBook = library.searchedBook("As Aventuras de Sharpe1");
		library.checkingBookOut(searchedBook);
		List<Book> checkedBooksOut = library.getCheckedBooksOut();
		int quantityCheckedBooksOut = checkedBooksOut.size();
		library.checkingBookIn(checkedBooksOut.get(0));
		int quantityCheckedBooksOutAfterDevolution = checkedBooksOut.size();
		assertThat(
				quantityCheckedBooksOutAfterDevolution < quantityCheckedBooksOut,
				is(true));

	}

}
