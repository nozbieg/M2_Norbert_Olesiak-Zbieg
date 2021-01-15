package com.nolesiak.bookstoreapp.services;


import com.nolesiak.bookstoreapp.api.mapper.BookMapper;
import com.nolesiak.bookstoreapp.api.mapper.CustomerMapper;
import com.nolesiak.bookstoreapp.api.model.BookDTO;
import com.nolesiak.bookstoreapp.api.model.CustomerDTO;
import com.nolesiak.bookstoreapp.domain.Book;
import com.nolesiak.bookstoreapp.domain.Customer;
import com.nolesiak.bookstoreapp.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;
    CustomerMapper customerMapper;
    BookMapper bookMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper, BookMapper bookMapper){
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                                 .stream()
                                 .map(customerMapper::customerToCustomerDTO)
                                 .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long customerId) {
        return customerMapper.customerToCustomerDTO(customerRepository.findById(customerId).get());
    }

    @Override
    public List<BookDTO> getAllCustomerBooks(Long customerId) {
        return customerRepository.findById(customerId)
                                 .get()
                                 .getBorrowedBooks()
                                 .stream()
                                 .map(bookMapper::bookToBookDTO)
                                 .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(savedCustomer);
    }

    @Override
    public CustomerDTO updateCustomer(Long customerID, CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer.setId(customerID);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(savedCustomer);
    }
}
