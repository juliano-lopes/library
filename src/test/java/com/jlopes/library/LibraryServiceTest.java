package com.jlopes.library;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class LibraryServiceTest {

@Test
public void shouldReturnListOfBooks(){
LibraryService libraryService = new LibraryService();
	List<Books> books = libraryService.getBooks();
	assertTrue(books.size()>0);
}
}