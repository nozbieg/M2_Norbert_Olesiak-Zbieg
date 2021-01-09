package com.nolesiak.bookstoreapp.controllers;


import com.nolesiak.bookstoreapp.api.model.BookDTO;
import com.nolesiak.bookstoreapp.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id){
        return new ResponseEntity<BookDTO>(bookService.getBookById(id),HttpStatus.OK);
    }
}
