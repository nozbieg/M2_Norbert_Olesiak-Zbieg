package com.nolesiak.bookstoreapp.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libraryName;

    @ManyToMany
    private List<Book> bookList;

    @OneToMany
    private List<Employee> employees;

    public void addBookToLibrary(Book book){
        bookList.add(book);
    }

    public void addEmployeeToLibrary(Employee employee){
        employees.add(employee);
    }

}
