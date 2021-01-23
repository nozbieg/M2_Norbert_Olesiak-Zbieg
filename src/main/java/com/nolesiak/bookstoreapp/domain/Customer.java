package com.nolesiak.bookstoreapp.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;

    @JsonManagedReference
    @OneToMany(mappedBy = "borrower", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> borrowedBooks = new ArrayList<Book>();

    public void borrowBook(Book book){
        if(book.getStatus() == "available"){
            borrowedBooks.add(book);
            //book.setBorrower(this);
            book.setStatus("unavailable");
        }

    }
}
