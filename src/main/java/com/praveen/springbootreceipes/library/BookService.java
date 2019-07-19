package com.praveen.springbootreceipes.library;

import java.util.Optional;

public interface BookService {
    Iterable<Book> findAll();
    Optional<Book> find();
    Book createBook(Book book);
}
