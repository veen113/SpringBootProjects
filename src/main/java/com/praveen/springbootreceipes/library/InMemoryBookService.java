package com.praveen.springbootreceipes.library;

import java.util.Optional;

public class InMemoryBookService implements BookService {
    @Override
    public Iterable<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> find() {
        return Optional.empty();
    }

    @Override
    public Book createBook(Book book) {
        return null;
    }
}
