package com.nolesiak.bookstoreapp.api.mapper;

import com.nolesiak.bookstoreapp.api.model.CustomerDTO;
import com.nolesiak.bookstoreapp.api.model.LibraryDTO;
import com.nolesiak.bookstoreapp.domain.Customer;
import com.nolesiak.bookstoreapp.domain.Library;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LibraryMapper {
    LibraryMapper INSTANCE = Mappers.getMapper(LibraryMapper.class);

    LibraryDTO libraryToLibraryDTO(Library library);

    Library libraryDTOToLibrary(LibraryDTO libraryDTO);
}
