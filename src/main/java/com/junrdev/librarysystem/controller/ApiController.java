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

    /***
     * default constructor to do dependency injection
     * @param service
     */
    @Autowired
    public ApiController(BookService service) {
        this.service = service;
    }

    /***
     * fetch all the books from the current repository
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(service.getAllBooks());
    }

    /***
     * get the book by the registered id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(service.getBookById(id));
    }

    /***
     * get the book with a specific title
     * @param title
     * @return
     */
    @GetMapping(params = {"title"})
    public ResponseEntity<Book> getBookbyTitle(@RequestParam(name = "title") String title){
        return ResponseEntity.ok(service.getBookByTitle(title));
    }

    /***
     * get all the books associated with an author
     * @param author
     * @return
     */
    @GetMapping(params = {"author"})
    public ResponseEntity<List<Book>> getBooksbyAuthor(@RequestParam(name = "author") String author){
        return ResponseEntity.ok(service.getAuthorBooks(author));
    }

    /***
     * create a new book item by using a book dto
     * @param dto
     * @return
     */
    @PostMapping("/new")
    public ResponseEntity<String> createBook(@RequestBody(required = true) BookDTO dto){
        return new ResponseEntity<String>(service.addBook(dto), HttpStatusCode.valueOf(201));
    }

    /***
     * handler to update the book url to cover photo
     * @param title
     * @param urlToImage
     * @return
     */
    @PatchMapping(params = {"title"})
    public ResponseEntity<Book> updateBook(@RequestParam(name = "title") String title, @RequestBody String urlToImage){
        Book book = service.getBookByTitle(title);

        book.setUrl_to_cover_photo(urlToImage);

        return ResponseEntity.ok(service.updateBook(book));
    }
}
