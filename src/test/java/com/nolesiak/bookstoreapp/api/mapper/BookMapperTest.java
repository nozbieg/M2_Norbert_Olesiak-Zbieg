package com.nolesiak.bookstoreapp.api.mapper;

import com.nolesiak.bookstoreapp.api.model.BookDTO;
import com.nolesiak.bookstoreapp.domain.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookMapperTest {

    BookMapper bookMapper = BookMapper.INSTANCE;

    @Test
    void bookToBookDTO() {
        //given
        Book book = new Book();
        book.setId(2L);
        book.setTitle("Simple book");
        book.setStatus("available");

        //when
        BookDTO bookDTO = bookMapper.bookToBookDTO(book);

        //then
        assertEquals(Long.valueOf(2L), bookDTO.getId());
        assertEquals("Simple book", bookDTO.getTitle());
        assertEquals("available", bookDTO.getStatus());
    }
}