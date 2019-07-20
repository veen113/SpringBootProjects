package com.praveen.springbootreceipes.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BookService bookService;

    @GetMapping
    public Iterable<Book> findAll() {
        return bookService.findAll();
    }


    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book, UriComponentsBuilder uriComponentsBuilder) {
        Book createdBook = bookService.createBook(book);
        URI newBookUri = uriComponentsBuilder.path("/books/{isbn}").build(createdBook.getIsbn());
        return ResponseEntity.created(newBookUri).body(createdBook);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> findBook(@PathVariable("isbn") String isbn) {
        return bookService.find(isbn)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
