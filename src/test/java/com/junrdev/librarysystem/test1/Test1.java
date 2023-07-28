package com.junrdev.librarysystem.test1;

import com.junrdev.librarysystem.dto.BookDTO;
import com.junrdev.librarysystem.model.Book;
import com.junrdev.librarysystem.repo.BookRepo;
import com.junrdev.librarysystem.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

/***
 * Initial test
 * Includes test on the bookRepo and all the methods
 */
@SpringBootTest
public class Test1 {


    private final BookService service;

    @Autowired
    public Test1(BookService service) {
        this.service = service;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void addBook() {
        String res = service.addBook(BookDTO.builder()
                .title("Book One")
                .author("Yobra")
                .category("category-1")
                .noOfPages(1234)
                .isbn(UUID.randomUUID().toString())
                .coverPhoto("https://www.example.com/demo.png")
                .build());

        System.out.println("res = " + res);
    }

    @Test
    void getAllBooks(){

        List<Book> books = service.getAllBooks();

        System.out.println("books = " + books);
    }

    @Test
    void getBookByTitle(){
        Book _b = service.getBookByTitle("Book One");
        System.out.println("Book = " + _b.toString());
    }

    @Test
    void deleteByTitle(){
        service.deleteByTitle("Book One");
    }
}
