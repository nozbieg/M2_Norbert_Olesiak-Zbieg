package com.nolesiak.bookstoreapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libraryName;

    @ManyToMany
    private List<Book> bookList;

    @OneToMany
    private List<Employee> employees;
}
