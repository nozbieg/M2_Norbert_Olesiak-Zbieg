package com.nolesiak.bookstoreapp.services;


import com.nolesiak.bookstoreapp.api.model.BookDTO;

import java.util.List;


public interface BookService {

    List<BookDTO> getAllBooks();

    BookDTO getBookById(Long id);

    List<BookDTO> getBookByStatus(String status);
}
