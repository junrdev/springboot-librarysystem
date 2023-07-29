package com.junrdev.librarysystem.repo;

import com.junrdev.librarysystem.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, String> {

    Book findBookByTitle(String title);

    List<Book> findBooksByAuthor(String Author);

    Book findBookByCategory(String Category);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM book b WHERE b.title= :title")
    void removeBookWithTitle(@Param(value = "title") String title);


}
