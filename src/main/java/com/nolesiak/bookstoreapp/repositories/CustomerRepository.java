package com.nolesiak.bookstoreapp.repositories;

import com.nolesiak.bookstoreapp.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
