package com.junrdev.librarysystem.service;

import com.junrdev.librarysystem.dto.BookDTO;
import com.junrdev.librarysystem.model.Book;
import com.junrdev.librarysystem.repo.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class BookService {

    private final BookRepo bookRepo;

    /***
     * Parameterized dependency injection
     * @param bookRepo the book repository interface object
     */
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book getBookById(String id){
        return bookRepo.findById(id).isEmpty() ? null : bookRepo.findById(id).get();
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public String addBook(BookDTO dto) {

        Book book = Book.builder()
                .Id(UUID.randomUUID().toString())
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .NoOfPages(dto.getNoOfPages())
                .ISBN_Number(dto.getIsbn())
                .category(dto.getCategory())
                .url_to_cover_photo(dto.getCoverPhoto())
                .build();

        Book _b = bookRepo.save(book);

        return "Book with Id " + _b.getId() + " saved";
    }


    public void deleteByTitle(String title) {
        if (bookRepo.findBookByTitle(title) != null)
            bookRepo.removeBookWithTitle(title);
    }

    public Book updateBook(Book book) {
        return bookRepo.findById(book.getId()).isPresent() ? bookRepo.save(book) : null;
    }


    public Book getBookByTitle(String title){
        return bookRepo.findBookByTitle(title);
    }

    public List<Book> getAuthorBooks(String author){
        return bookRepo.findBooksByAuthor(author);
    }
}
