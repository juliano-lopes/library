package com.jlopes.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.jlopes.library.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
