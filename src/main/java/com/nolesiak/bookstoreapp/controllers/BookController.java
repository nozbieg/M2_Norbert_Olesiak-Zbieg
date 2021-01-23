package com.nolesiak.bookstoreapp.controllers;


import com.nolesiak.bookstoreapp.api.model.BookDTO;
import com.nolesiak.bookstoreapp.api.model.BookListDTO;
import com.nolesiak.bookstoreapp.api.model.CustomerDTO;
import com.nolesiak.bookstoreapp.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book/")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @GetMapping("getAllBooks")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> getAllCustomers(){
        return bookService.getAllBooks();
    }

    @GetMapping("findByStatus/{status}")
    public ResponseEntity<BookListDTO> getBooksByStatus(@PathVariable String status){
        return new ResponseEntity<BookListDTO>(
                new BookListDTO(bookService.getBooksByStatus(status)), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<BookDTO> createNewBook(@RequestBody BookDTO bookDTO){
        return new ResponseEntity<BookDTO>(bookService.createNewBook(bookDTO), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO){
        return new ResponseEntity<BookDTO>(bookService.updateBook(id,bookDTO), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
