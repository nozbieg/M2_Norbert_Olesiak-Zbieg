package com.nolesiak.bookstoreapp.bootstrap;

import com.nolesiak.bookstoreapp.domain.Book;
import com.nolesiak.bookstoreapp.domain.Customer;
import com.nolesiak.bookstoreapp.domain.Employee;
import com.nolesiak.bookstoreapp.domain.Library;
import com.nolesiak.bookstoreapp.repositories.BookRepository;
import com.nolesiak.bookstoreapp.repositories.CustomerRepository;
import com.nolesiak.bookstoreapp.repositories.EmployeeRepository;
import com.nolesiak.bookstoreapp.repositories.LibraryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DBDataLoader implements CommandLineRunner
{

    BookRepository bookRepository;
    LibraryRepository libraryRepository;
    CustomerRepository customerRepository;
    EmployeeRepository employeeRepository;

    public DBDataLoader(BookRepository bookRepository,
                        LibraryRepository libraryRepository,
                        CustomerRepository customerRepository,
                        EmployeeRepository employeeRepository)
    {
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public void run(String... args) throws Exception
    {
        addLibrariesToDatabase();
        addEmployessToDatabase();
        addBooksToDatabase();
        addCustomersToDatabase();

        System.out.println("Data loaded to DB!");
    }

    public void addLibrariesToDatabase()
    {
        Library grandLibrary = new Library();
        grandLibrary.setLibraryName("Grand Library");

        Library smallLibrary = new Library();
        smallLibrary.setLibraryName("Small Library");

        libraryRepository.save(grandLibrary);
        libraryRepository.save(smallLibrary);
    }

    public void addEmployessToDatabase()
    {
        Employee accountant = new Employee();
        accountant.setEmployeeName("Accountant");

        Employee secondAccountant = new Employee();
        secondAccountant.setEmployeeName("Second Accountant");

        Employee worker = new Employee();
        worker.setEmployeeName("Second Worker");

        Employee secondWorker = new Employee();
        secondWorker.setEmployeeName("Second Worker");

        employeeRepository.save(accountant);
        employeeRepository.save(secondAccountant);
        employeeRepository.save(secondWorker);
        employeeRepository.save(worker);
    }

    public void addBooksToDatabase()
    {
        Book java = new Book();
        java.setTitle("Learn Java");
        java.setStatus("available");

        Book beginnerC = new Book();
        beginnerC.setTitle("Beginner C");
        beginnerC.setStatus("available");

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
        bookRepository.save(beginnerC);
        bookRepository.save(machineLearning);
        bookRepository.save(easyCPlus);
        bookRepository.save(python);

        addBookToLibrary(java, 1L);
        addBookToLibrary(beginnerC, 1L);
        addBookToLibrary(machineLearning, 1L);
        addBookToLibrary(easyCPlus, 2L);
        addBookToLibrary(python, 2L);

    }

    public void addCustomersToDatabase()
    {
        Customer janek = new Customer();
        janek.setCustomerName("Janek");

        Customer zuzia = new Customer();
        zuzia.setCustomerName("Zuzia");

        customerRepository.save(janek);
        customerRepository.save(zuzia);
        borrowSomeBooks(janek, 1L);
        borrowSomeBooks(zuzia, 2L);
    }

    public void borrowSomeBooks(Customer customer, Long id){
        Book book = bookRepository.findById(id).get();
        customer.borrowBook(book);
        customerRepository.save(customer);
        bookRepository.save(book);

    }

    public void addBookToLibrary(Book book, Long id){
        Library library = libraryRepository.findById(id).get();
        book.addLibraryToBook(library);
        bookRepository.save(book);

    }



}
