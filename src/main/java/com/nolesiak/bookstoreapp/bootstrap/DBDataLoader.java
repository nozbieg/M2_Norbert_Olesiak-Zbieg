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
        beginerC.setTitle("Beginer C");
        beginerC.setStatus("available");

        Book machineLearning = new Book();
        machineLearning.setTitle("Machine Learning in Go");
        machineLearning.setStatus("available");

        Book easyCPlus = new Book();
        easyCPlus.setTitle("Easy C++");
        easyCPlus.setStatus("available");

        Book python = new Book();
        python.setTitle("New snake called Python");
        python.setStatus("available");

        bookRepository.save(java);
        bookRepository.save(beginerC);
        bookRepository.save(machineLearning);
        bookRepository.save(easyCPlus);
        bookRepository.save(python);

        System.out.println("Data loaded to DB!");
    }
}
