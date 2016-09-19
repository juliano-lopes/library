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
		Books book = library.shearchedBook("Se Houver Amanhã");
		String author = book.getAuthor();
		assertThat(author, is("Sidney Sheldon"));
	}

	@Test
	public void shouldReturnNullBecauseBookTitleNotExists() {
		LibraryService libraryService = new LibraryService();
		LibraryManager library = new LibraryManager(libraryService.getBooks());
		Books book = library.shearchedBook("Ordem dos Arqueiros");
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
}
