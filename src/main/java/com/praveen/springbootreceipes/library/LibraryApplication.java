package com.praveen.springbootreceipes.library;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class,args);
    }

    @Bean
    public ApplicationRunner booksInitializer(BookService bookService) {
        return args -> {
            bookService.createBook(
                    new Book("9780061120084","To Kill a MockingBoard", "Harper Lee")
            );
            bookService.createBook(
                    new Book("9780061120085","To Kill a MockingBoard", "Harper Lee")
            );
            bookService.createBook(
                    new Book("9780061120086","To Kill a MockingBoard", "Harper Lee")
            );
        };
    }
}
