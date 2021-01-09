package com.nolesiak.bookstoreapp.repositories;

import com.nolesiak.bookstoreapp.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> getByStatus(String status);
}
