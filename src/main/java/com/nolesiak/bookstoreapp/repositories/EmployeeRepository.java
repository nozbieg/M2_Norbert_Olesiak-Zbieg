package com.nolesiak.bookstoreapp.repositories;

import com.nolesiak.bookstoreapp.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
