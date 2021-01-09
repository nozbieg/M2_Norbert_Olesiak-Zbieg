package com.nolesiak.bookstoreapp.api.mapper;


import com.nolesiak.bookstoreapp.api.model.BookDTO;
import com.nolesiak.bookstoreapp.domain.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO bookToBookDTO(Book book);

    Book bookDTOToBook(BookDTO bookDTO);
}
