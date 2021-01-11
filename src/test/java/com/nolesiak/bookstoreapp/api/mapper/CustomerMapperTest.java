package com.nolesiak.bookstoreapp.api.mapper;

import com.nolesiak.bookstoreapp.api.model.BookDTO;
import com.nolesiak.bookstoreapp.api.model.CustomerDTO;
import com.nolesiak.bookstoreapp.domain.Book;
import com.nolesiak.bookstoreapp.domain.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerMapperTest {

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    void customerToCustomerDTO() {
        //given
        Customer customer = new Customer();
        customer.setId(2L);
        customer.setCustomerName("Janek");

        Book book = new Book();
        book.setId(1L);
        book.setTitle("C# is better");
        book.setStatus("available");

        customer.borrowBook(book);

        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //then
        assertEquals(Long.valueOf(2L), customerDTO.getId());
        assertEquals("Janek", customerDTO.getCustomerName());
        assertEquals(1, customerDTO.getBorrowedBooks().stream().count());
    }
}
