package com.nolesiak.bookstoreapp.api.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookListDTO {

    private List<BookDTO> bookList;
}
