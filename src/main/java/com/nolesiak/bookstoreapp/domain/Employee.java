package com.nolesiak.bookstoreapp.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employeeName;

    @ManyToOne
    private Library library;
}
