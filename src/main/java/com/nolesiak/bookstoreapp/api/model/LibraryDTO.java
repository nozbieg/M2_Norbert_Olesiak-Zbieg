package com.nolesiak.bookstoreapp.api.model;

import com.nolesiak.bookstoreapp.domain.Book;
import com.nolesiak.bookstoreapp.domain.Employee;
import lombok.Data;

import java.util.List;

@Data
public class LibraryDTO {
    private Long id;
    private String libraryName;
    private List<Book> bookList;
    private List<Employee> employees;
}
