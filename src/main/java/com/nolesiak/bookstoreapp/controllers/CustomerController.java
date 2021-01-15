package com.nolesiak.bookstoreapp.controllers;

import com.nolesiak.bookstoreapp.api.mapper.BookMapper;
import com.nolesiak.bookstoreapp.api.model.BookDTO;
import com.nolesiak.bookstoreapp.api.model.CustomerDTO;
import com.nolesiak.bookstoreapp.domain.Book;
import com.nolesiak.bookstoreapp.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {

    private final CustomerService customerService;
    private BookMapper bookMapper;

    public CustomerController(CustomerService customerService, BookMapper bookMapper) {
        this.customerService = customerService;
        this.bookMapper = bookMapper;
    }

    @GetMapping("getAllCustomers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("getCustomerById/{id}")
    @ResponseStatus(HttpStatus.OK)
    CustomerDTO getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }
    @GetMapping("getCustomerBooks/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> getAllCustomerBooks(@PathVariable Long customerId){
        return  customerService.getCustomerById(customerId)
                                .getBorrowedBooks()
                                .stream()
                                .map(bookMapper::bookToBookDTO)
                                .collect(Collectors.toList());
    }

    //CustomerDTO createNewCustomer(CustomerDTO customerDTO);

    //CustomerDTO updateCustomer(Long customerID, CustomerDTO customerDTO);
}
