package com.junrdev.librarysystem.controller;


import com.junrdev.librarysystem.dto.BookDTO;
import com.junrdev.librarysystem.model.Book;
import com.junrdev.librarysystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class ApiController {

    private final BookService service;

    @Autowired
    public ApiController(BookService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(service.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(service.getBookById(id));
    }

//    @GetMapping("/{title}")
//    public ResponseEntity<Book> getBookbyTitle(@PathVariable(name = "title") String title){
//        return ResponseEntity.ok(service.getBookByTitle(title));
//    }


    @PostMapping("/new")
    public ResponseEntity<String> createBook(BookDTO dto){
        return new ResponseEntity<String>(service.addBook(dto), HttpStatusCode.valueOf(201));
    }
}
