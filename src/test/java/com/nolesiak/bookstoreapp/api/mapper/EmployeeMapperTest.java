package com.nolesiak.bookstoreapp.api.mapper;

import com.nolesiak.bookstoreapp.api.model.CustomerDTO;
import com.nolesiak.bookstoreapp.api.model.EmployeeDTO;
import com.nolesiak.bookstoreapp.domain.Book;
import com.nolesiak.bookstoreapp.domain.Customer;
import com.nolesiak.bookstoreapp.domain.Employee;
import com.nolesiak.bookstoreapp.domain.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeMapperTest {
    EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;

    @Test
    void employeeToEmployeeDTO() {
        //given
        Employee employee = new Employee();
        employee.setId(2L);
        employee.setEmployeeName("Employee");

        Library library = new Library();
        library.setId(1L);
        library.setLibraryName("Grand Library");

        employee.setLibrary(library);

        //when
        EmployeeDTO employeeDTO = employeeMapper.employeeToEmployeeDTO(employee);

        //then
        assertEquals(Long.valueOf(2L), employeeDTO.getId());
        assertEquals("Employee", employeeDTO.getEmployeeName());
        assertEquals("Grand Library", employeeDTO.getLibrary().getLibraryName());
    }
}
