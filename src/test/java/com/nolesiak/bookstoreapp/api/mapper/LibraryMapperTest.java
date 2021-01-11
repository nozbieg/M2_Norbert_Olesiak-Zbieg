package com.nolesiak.bookstoreapp.api.mapper;

import com.nolesiak.bookstoreapp.api.model.EmployeeDTO;
import com.nolesiak.bookstoreapp.api.model.LibraryDTO;
import com.nolesiak.bookstoreapp.domain.Book;
import com.nolesiak.bookstoreapp.domain.Employee;
import com.nolesiak.bookstoreapp.domain.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryMapperTest {

    LibraryMapper libraryMapper = LibraryMapper.INSTANCE;

    @Test
    void libraryToLibraryDTO() {
        //given
        Library library = new Library();
        library.setId(2L);
        library.setLibraryName("Grand Library");

        Book book = new Book();
        book.setId(2L);
        book.setTitle("Simple book");
        book.setStatus("available");
        Book book2 = new Book();
        book.setId(1L);
        book.setTitle("Simple book2");
        book.setStatus("unavailable");

        library.addBookToLibrary(book);
        library.addBookToLibrary(book2);

        Employee employee = new Employee();
        employee.setId(2L);
        employee.setEmployeeName("Employee");

        library.addEmployeeToLibrary(employee);

        //when
        LibraryDTO libraryDTO = libraryMapper.libraryToLibraryDTO(library);

        //then
        assertEquals(Long.valueOf(2L), libraryDTO.getId());
        assertEquals(1, libraryDTO.getEmployees().stream().count());
        assertEquals(2, libraryDTO.getBookList().stream().count());
    }
}
