package com.jlopes.library;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.jlopes.library.domain.Book;
import com.jlopes.library.service.BookService;

public class LibraryManagerTest {
	private LibraryManager library;

	@Before
	public void setUp() {
		BookService bookService = new BookService();
		library = new LibraryManager(bookService);
	}

	@Test
	public void shouldReturnTrueIfQuantityBooksBiggerThanZero() {
		int quantityBooks = library.getBooks().size();
		assertThat((quantityBooks > 0), is(true));
	}

	@Test
	public void shouldReturnBookAuthorIfBookFound() {
		Book book = library.searchedBook("Se Houver Amanh�");
		String author = book.getAuthor();
		assertThat(author, is("Sidney Sheldon"));
	}

	@Test
	public void shouldReturnNullBecauseBookTitleNotExists() {
		Book book = library.searchedBook("Ordem dos Arqueiros");
		assertNull(book);
	}

	@Test
	public void shouldReturnTrueIfBookCheckedOut() {
		Book searchedBook = library.searchedBook("Se Houver Amanh�");
		boolean result = library.takingBook(searchedBook);
		assertTrue(result);
	}

	@Test
	public void shouldReturnListWithCheckedBooksOut() {
		Book searchedBook = library.searchedBook("Se Houver Amanh�");
		library.takingBook(searchedBook);
		searchedBook = library.searchedBook("As Aventuras de Sharpe1");
		library.takingBook(searchedBook);
		List<Book> result = library.getUnavailableBooks();
		assertTrue(result != null);
	}

	@Test
	public void shouldReturnBookTitleFirstOneCheckedOut() {
		Book searchedBook = library.searchedBook("Se Houver Amanh�");
		library.takingBook(searchedBook);
		searchedBook = library.searchedBook("As Aventuras de Sharpe1");
		library.takingBook(searchedBook);
		List<Book> checkedBooksOut = library.getUnavailableBooks();
		String result = checkedBooksOut.get(0).getTitle();
		assertThat(result, is("Se Houver Amanh�"));
	}

	@Test
	public void shouldReturnQuantityAvailableBooks() {
		Book searchedBook = library.searchedBook("Se Houver Amanh�");
		library.takingBook(searchedBook);
		searchedBook = library.searchedBook("As Aventuras de Sharpe1");
		library.takingBook(searchedBook);
		List<Book> availableBooks = library.availableBooks();
		int quantityAvailableBooks = availableBooks.size();
		int quantityBooks = library.getBooks().size();
		assertThat(quantityAvailableBooks, is(quantityBooks - 2));
	}

	@Test
	public void shouldReturnQuantityCheckedBooksOut() {
		Book searchedBook = library.searchedBook("Se Houver Amanh�");
		library.takingBook(searchedBook);
		searchedBook = library.searchedBook("As Aventuras de Sharpe1");
		library.takingBook(searchedBook);
		List<Book> checkedBooksOut = library.getUnavailableBooks();
		int quantityCheckedBooksOut = checkedBooksOut.size();
		assertThat(quantityCheckedBooksOut, is(2));
	}

	@Test
	public void shouldReturnTrueIfQuantityCheckedBooksOutIsLeastAfterCheckBookIn() {
		Book searchedBook = library.searchedBook("Se Houver Amanh�");
		library.takingBook(searchedBook);
		searchedBook = library.searchedBook("As Aventuras de Sharpe1");
		library.takingBook(searchedBook);
		List<Book> checkedBooksOut = library.getUnavailableBooks();
		int quantityCheckedBooksOut = checkedBooksOut.size();
		library.returningBook(checkedBooksOut.get(0));
		int quantityCheckedBooksOutAfterDevolution = checkedBooksOut.size();
		assertThat(
				quantityCheckedBooksOutAfterDevolution < quantityCheckedBooksOut,
				is(true));
	}

}
