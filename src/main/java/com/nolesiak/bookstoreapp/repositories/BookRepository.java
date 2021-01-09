package com.nolesiak.bookstoreapp.repositories;

import com.nolesiak.bookstoreapp.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
