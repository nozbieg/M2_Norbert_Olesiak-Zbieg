package com.nolesiak.bookstoreapp.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer borrower;

    @ManyToMany
    private List<Library> libraries = new ArrayList<Library>();

    public void addLibraryToBook(Library library){
        libraries.add(library);
    }
}
