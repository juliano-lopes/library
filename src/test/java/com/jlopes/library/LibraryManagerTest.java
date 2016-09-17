package com.jlopes.library;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class LibraryManagerTest {
	@Test
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

}
