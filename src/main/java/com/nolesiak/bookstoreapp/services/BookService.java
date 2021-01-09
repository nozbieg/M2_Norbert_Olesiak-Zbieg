package com.nolesiak.bookstoreapp.services;


import com.nolesiak.bookstoreapp.api.model.BookDTO;

import java.util.List;


public interface BookService {

    List<BookDTO> getAllBooks();

    BookDTO getBookById(Long id);

    List<BookDTO> getBooksByStatus(String status);

    BookDTO createNewBook(BookDTO bookDTO);

    BookDTO updateBook(Long id, BookDTO bookDTO);

    void deleteBookById(Long id);
}
