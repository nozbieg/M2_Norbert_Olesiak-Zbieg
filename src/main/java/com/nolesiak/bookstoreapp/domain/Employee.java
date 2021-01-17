package com.nolesiak.bookstoreapp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employeeName;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Library library;
}
