package com.nolesiak.bookstoreapp.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String status;

    @ManyToOne
    private Customer borrower;

    @ManyToMany
    private List<Library> libraries;
}
