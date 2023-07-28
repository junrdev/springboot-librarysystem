package com.junrdev.librarysystem;

import com.junrdev.librarysystem.dto.BookDTO;
import com.junrdev.librarysystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class LibrarysystemApplication implements CommandLineRunner {

    @Autowired
    private BookService service;

    public static void main(String[] args) {
        SpringApplication.run(LibrarysystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        service.addBook(BookDTO.builder().
//                title("Hello java")
//                .author("Brian")
//                .category("Java")
//                .coverPhoto("google.com")
//                .isbn(UUID.randomUUID().toString())
//                .noOfPages(200)
//                .build()
//        );
    }
}
