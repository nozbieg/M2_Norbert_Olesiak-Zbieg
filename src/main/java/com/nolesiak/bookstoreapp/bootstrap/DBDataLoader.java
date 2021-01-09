package com.nolesiak.bookstoreapp.bootstrap;

import com.nolesiak.bookstoreapp.domain.Book;
import com.nolesiak.bookstoreapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataLoader implements CommandLineRunner {

    BookRepository bookRepository;

    public DBDataLoader(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Book java = new Book();
        java.setTitle("Learn Java");
        java.setStatus("available");

        Book beginerC = new Book();
        java.setTitle("Beginer C");
        java.setStatus("available");

        Book machineLearning = new Book();
        java.setTitle("Machine Learning in Go");
        java.setStatus("available");

        Book easyCPlus = new Book();
        java.setTitle("Easy C++");
        java.setStatus("available");

        Book python = new Book();
        java.setTitle("New snake called 'Python'");
        java.setStatus("available");

        bookRepository.save(java);
        bookRepository.save(beginerC);
        bookRepository.save(machineLearning);
        bookRepository.save(easyCPlus);
        bookRepository.save(python);

        System.out.println("Data loaded to DB!");
    }
}
