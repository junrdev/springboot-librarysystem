package com.junrdev.librarysystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "unique_title", columnNames = {"title"})
}, name = "book")
public class Book {

    @jakarta.persistence.Id
    private String Id;

    private String title;

    private String author;

    private String category;

    private String ISBN_Number;

    private String url_to_cover_photo;

    private int NoOfPages;


}
