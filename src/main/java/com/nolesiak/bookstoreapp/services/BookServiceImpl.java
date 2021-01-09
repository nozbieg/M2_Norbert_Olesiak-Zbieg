package com.nolesiak.bookstoreapp.services;


import com.nolesiak.bookstoreapp.api.mapper.BookMapper;
import com.nolesiak.bookstoreapp.api.model.BookDTO;
import com.nolesiak.bookstoreapp.domain.Book;
import com.nolesiak.bookstoreapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{

    BookRepository bookRepository;
    BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository,
                           BookMapper bookMapper){
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;

    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long id) {
        return bookMapper.bookToBookDTO(bookRepository.findById(id).get());
    }

    @Override
    public List<BookDTO> getBooksByStatus(String status) {
        return bookRepository.getByStatus(status)
                .stream()
                .map(bookMapper::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO createNewBook(BookDTO bookDTO) {
       Book book = bookMapper.bookDTOToBook(bookDTO);
       Book savedBook = bookRepository.save(book);
       return bookMapper.bookToBookDTO(savedBook);
    }
}
