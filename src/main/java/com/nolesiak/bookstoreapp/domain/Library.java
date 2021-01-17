package com.nolesiak.bookstoreapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libraryName;

    @ManyToMany
    private List<Book> bookList = new ArrayList<Book>();

    @OneToMany
    private List<Employee> employees = new ArrayList<Employee>();

    public void addBookToLibrary(Book book){
        bookList.add(book);
    }

    public void addEmployeeToLibrary(Employee employee){
        employees.add(employee);
    }

}
