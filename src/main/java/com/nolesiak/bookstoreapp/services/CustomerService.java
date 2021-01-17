package com.nolesiak.bookstoreapp.services;

import com.nolesiak.bookstoreapp.api.model.BookDTO;
import com.nolesiak.bookstoreapp.api.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long customerId);

    List<BookDTO> getAllCustomerBooks(Long customerId);

    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(Long customerID, CustomerDTO customerDTO);

    void deleteCustomerById(Long customerID);

    void borrowBook(Long customerID, BookDTO bookDTO);
}
