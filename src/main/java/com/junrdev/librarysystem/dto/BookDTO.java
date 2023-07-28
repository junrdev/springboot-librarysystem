package com.junrdev.librarysystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * The data transfer object (dto) for the book class
 * To be used to minimize the parameters passed during a Book object creation
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {

    private String title;
    private String author;
    private int noOfPages;
    private String category;

    private String isbn;
    private String coverPhoto;
}
