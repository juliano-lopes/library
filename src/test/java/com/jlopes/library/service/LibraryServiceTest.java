package com.jlopes.library.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.jlopes.library.domain.Book;
import com.jlopes.library.service.LibraryService;

public class LibraryServiceTest {

@Test
public void shouldReturnListOfBooks(){
LibraryService libraryService = new LibraryService();
	List<Book> books = libraryService.getBooks();
	assertTrue(books.size()>0);
}
}