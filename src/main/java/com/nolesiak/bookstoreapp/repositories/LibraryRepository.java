package com.nolesiak.bookstoreapp.repositories;

import com.nolesiak.bookstoreapp.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}
