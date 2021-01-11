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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;

    @OneToMany
    private List<Book> borrowedBooks;

    public void borrowBook(Book book){
        if(book.getStatus() == "available"){
            borrowedBooks.add(book);
            book.setStatus("unavailable");
        }

    }
}
