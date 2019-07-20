package com.praveen.springbootreceipes.library;

import java.util.Optional;

public interface BookService {
    Iterable<Book> findAll();
    Optional<Book> find(String isbn);
    Book createBook(Book book);
}
