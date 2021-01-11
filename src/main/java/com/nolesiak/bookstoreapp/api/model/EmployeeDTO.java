package com.nolesiak.bookstoreapp.api.model;

import com.nolesiak.bookstoreapp.domain.Library;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class EmployeeDTO {
    private Long id;
    private String employeeName;
    private Library library;
}
