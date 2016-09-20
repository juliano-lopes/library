package com.jlopes.library;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class LibraryManagerTest {
	@Test(expected = LibraryManagerDataShouldNotBeNullException.class)
	public void shouldReturnLibraryManagerDataShouldNotBeNullException() {
		List<Books> books = null;
		new LibraryManager(books);
	}

	public void shouldReturnTrueIfQuantityBooksBiggerThanZero() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		int quantityBooks = library.quantityBooks();
		assertThat((quantityBooks > 0), is(true));
	}

	@Test
	public void shouldReturnTrueIfBookAdded() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		Books book1 = new Books(6, "As Aventuras de Sharpe5",
				"Bernard Cornwell", "Fixão Histórica",
				"Literatura Estrangeira", "Record");
		Boolean result = library.addBook(book1);
		assertThat(result, is(true));
	}

	@Test
	public void shouldReturnTrueIfQuantityBooksIsBiggerAfterBookAdded() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		Books book1 = new Books(6, "As Aventuras de Sharpe5",
				"Bernard Cornwell", "Fixão Histórica",
				"Literatura Estrangeira", "Record");
		int quantityBooksBeforeAdd = library.quantityBooks();
		library.addBook(book1);
		int quantityBooksAfterAdd = library.quantityBooks();
		assertThat((quantityBooksAfterAdd > quantityBooksBeforeAdd), is(true));
	}

	@Test
	public void shouldReturnBookAuthorIfBookFound() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		Books book = library.searchedBook("Se Houver Amanhã");
		String author = book.getAuthor();
		assertThat(author, is("Sidney Sheldon"));
	}

	@Test
	public void shouldReturnNullBecauseBookTitleNotExists() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		Books book = library.searchedBook("Ordem dos Arqueiros");
		assertNull(book);
	}

	@Test
	public void shouldReturnTrueIfBookRemoved() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		boolean result = library.removeBook("As Aventuras de Sharpe1");
		assertTrue(result);
	}

	@Test
	public void shouldReturnFalseIfBookNotRemoved() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		boolean result = library.removeBook("Terra em Chama");
		assertThat(result, is(false));
	}

	@Test
	public void shouldReturnTrueIfBookRented() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		Users user = new Users("Juliano", "julopys@hotmail.com", "31993709668");
		Books searchedBook = library.searchedBook("Se Houver Amanhã");
		RentBooks rentBook = new RentBooks(user, searchedBook);
		boolean result = library.rentBook(rentBook);
		assertTrue(result);
	}

	@Test
	public void shouldReturnListwithLeasedBooks() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		Users user = new Users("Juliano", "julopys@hotmail.com", "31993709668");
		Books searchedBook = library.searchedBook("Se Houver Amanhã");
		RentBooks rentBook = new RentBooks(user, searchedBook);
		library.rentBook(rentBook);
		searchedBook = library.searchedBook("As Aventuras de Sharpe1");
		RentBooks rentBook2 = new RentBooks(user, searchedBook);
		library.rentBook(rentBook2);
		List<Books> result = library.leasedBooks();
		assertTrue(result != null);
	}

	@Test
	public void shouldReturnBookTitleFistOneRented() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		Users user = new Users("Juliano", "julopys@hotmail.com", "31993709668");
		Books searchedBook = library.searchedBook("Se Houver Amanhã");
		RentBooks rentBook = new RentBooks(user, searchedBook);
		library.rentBook(rentBook);
		searchedBook = library.searchedBook("As Aventuras de Sharpe1");
		RentBooks rentBook2 = new RentBooks(user, searchedBook);
		library.rentBook(rentBook2);
		List<Books> leasedBooks = library.leasedBooks();
		String result = leasedBooks.get(0).getTitle();
		assertThat(result, is("Se Houver Amanhã"));
	}

}
