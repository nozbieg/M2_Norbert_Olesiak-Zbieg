package com.nolesiak.bookstoreapp.api.model;

import com.nolesiak.bookstoreapp.domain.Customer;
import com.nolesiak.bookstoreapp.domain.Library;
import lombok.Data;

import java.util.List;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private String status;
    private Customer borrower;
    private List<Library> libraries;
}
