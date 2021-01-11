package com.nolesiak.bookstoreapp.api.model;

import com.nolesiak.bookstoreapp.domain.Book;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {
    private Long id;
    private String customerName;
    private List<Book> borrowedBooks;
}
